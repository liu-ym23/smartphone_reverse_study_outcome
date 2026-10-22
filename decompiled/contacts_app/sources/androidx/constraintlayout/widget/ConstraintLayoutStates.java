package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.bytedance.librarian.LibrarianImpl;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayoutStates {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private final ConstraintLayout mConstraintLayout;
    private SparseArray<ConstraintSet> mConstraintSetMap;
    private ConstraintsChangedListener mConstraintsChangedListener;
    int mCurrentConstraintNumber;
    int mCurrentStateId;
    ConstraintSet mDefaultConstraintSet;
    private SparseArray<State> mStateList;

    static class State {
        int mConstraintID;
        ConstraintSet mConstraintSet;
        int mId;
        ArrayList<Variant> mVariants;

        public State(Context context, XmlPullParser parser) {
            this.mVariants = new ArrayList();
            this.mConstraintID = -1;
            TypedArray r7 = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.State);
            int r0 = r7.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L13;
            int r2 = r7.getIndex(r1);
            if (r2 != R.styleable.State_android_id) goto L8;
            this.mId = r7.getResourceId(r2, this.mId);
        L12:
            r1 = r1 + 1;
            goto L3
        L8:
            if (r2 != R.styleable.State_constraints) goto L12;
            this.mConstraintID = r7.getResourceId(r2, this.mConstraintID);
            String r3 = context.getResources().getResourceTypeName(this.mConstraintID);
            context.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r3) == false) goto L12;
            ConstraintSet r4 = new ConstraintSet();
            this.mConstraintSet = r4;
            r4.clone(context, this.mConstraintID);
            goto L12
        L13:
            r7.recycle();
        }

        void add(Variant size) {
            this.mVariants.add(size);
        }

        public int findMatch(float width, float height) {
            int r0 = 0;
        L4:
            if (r0 >= this.mVariants.size()) goto L9;
            if (this.mVariants.get(r0).match(width, height) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L9:
            return -1;
        }
    }

    static class Variant {
        int mConstraintID;
        ConstraintSet mConstraintSet;
        int mId;
        float mMaxHeight;
        float mMaxWidth;
        float mMinHeight;
        float mMinWidth;

        public Variant(Context context, XmlPullParser parser) {
            this.mMinWidth = Float.NaN;
            this.mMinHeight = Float.NaN;
            this.mMaxWidth = Float.NaN;
            this.mMaxHeight = Float.NaN;
            this.mConstraintID = -1;
            TypedArray r7 = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.Variant);
            int r0 = r7.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L23;
            int r2 = r7.getIndex(r1);
            if (r2 != R.styleable.Variant_constraints) goto L10;
            this.mConstraintID = r7.getResourceId(r2, this.mConstraintID);
            String r3 = context.getResources().getResourceTypeName(this.mConstraintID);
            context.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r3) == false) goto L22;
            ConstraintSet r4 = new ConstraintSet();
            this.mConstraintSet = r4;
            r4.clone(context, this.mConstraintID);
        L22:
            r1 = r1 + 1;
            goto L3
        L10:
            if (r2 != R.styleable.Variant_region_heightLessThan) goto L13;
            this.mMaxHeight = r7.getDimension(r2, this.mMaxHeight);
            goto L22
        L13:
            if (r2 != R.styleable.Variant_region_heightMoreThan) goto L16;
            this.mMinHeight = r7.getDimension(r2, this.mMinHeight);
            goto L22
        L16:
            if (r2 != R.styleable.Variant_region_widthLessThan) goto L19;
            this.mMaxWidth = r7.getDimension(r2, this.mMaxWidth);
            goto L22
        L19:
            if (r2 != R.styleable.Variant_region_widthMoreThan) goto L21;
            this.mMinWidth = r7.getDimension(r2, this.mMinWidth);
            goto L22
        L21:
            Log.v("ConstraintLayoutStates", "Unknown tag");
            goto L22
        L23:
            r7.recycle();
        }

        boolean match(float widthDp, float heightDp) {
            if (Float.isNaN(this.mMinWidth) == true) goto L8;
            if (widthDp >= this.mMinWidth) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.mMinHeight) == true) goto L13;
            if (heightDp >= this.mMinHeight) goto L13;
            return false;
        L13:
            if (Float.isNaN(this.mMaxWidth) == true) goto L18;
            if (widthDp <= this.mMaxWidth) goto L18;
            return false;
        L18:
            if (Float.isNaN(this.mMaxHeight) == false) goto L20;
            return true;
        L20:
            if (heightDp <= this.mMaxHeight) goto L24;
            return false;
        L24:
            return true;
        }
    }

    ConstraintLayoutStates(Context context, ConstraintLayout layout, int resourceID) {
        this.mCurrentStateId = -1;
        this.mCurrentConstraintNumber = -1;
        this.mStateList = new SparseArray();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintsChangedListener = null;
        this.mConstraintLayout = layout;
        load(context, resourceID);
    }

    public boolean needsToChange(int id, float width, float height) {
        int r0 = this.mCurrentStateId;
        if (r0 == id) goto L6;
        return true;
    L6:
        if (id != (-1)) goto L8;
        State r5 = this.mStateList.valueAt(0);
    L9:
        State r6 = r5;
        if (this.mCurrentConstraintNumber == (-1)) goto L15;
        if (r6.mVariants.get(this.mCurrentConstraintNumber).match(width, height) == false) goto L15;
        return false;
    L15:
        if (this.mCurrentConstraintNumber != r6.findMatch(width, height)) goto L17;
        return false;
    L17:
        return true;
    L8:
        r5 = this.mStateList.get(r0);
        goto L9
    }

    public void updateConstraints(int id, float width, float height) {
        int r0 = this.mCurrentStateId;
        if (r0 != id) goto L29;
        if (id != (-1)) goto L6;
        State r5 = this.mStateList.valueAt(0);
    L8:
        if (this.mCurrentConstraintNumber != (-1)) goto L10;
    L12:
        int r6 = r5.findMatch(width, height);
        if (this.mCurrentConstraintNumber != r6) goto L15;
        return;
    L15:
        if (r6 != (-1)) goto L17;
        ConstraintSet r7 = this.mDefaultConstraintSet;
    L18:
        if (r6 != (-1)) goto L20;
        int r8 = r5.mConstraintID;
    L21:
        if (r7 != null) goto L23;
        return;
    L23:
        this.mCurrentConstraintNumber = r6;
        ConstraintsChangedListener r9 = this.mConstraintsChangedListener;
        if (r9 == null) goto L26;
        r9.preLayoutChange(-1, r8);
    L26:
        r7.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener r4 = this.mConstraintsChangedListener;
        if (r4 == null) goto L46;
        r4.postLayoutChange(-1, r8);
        return;
    L46:
        return;
    L20:
        r8 = r5.mVariants.get(r6).mConstraintID;
        goto L21
    L17:
        r7 = r5.mVariants.get(r6).mConstraintSet;
        goto L18
    L10:
        if (r5.mVariants.get(this.mCurrentConstraintNumber).match(width, height) == false) goto L12;
        return;
    L6:
        r5 = this.mStateList.get(r0);
        goto L8
    L29:
        this.mCurrentStateId = id;
        State r1 = this.mStateList.get(id);
        int r2 = r1.findMatch(width, height);
        if (r2 != (-1)) goto L32;
        ConstraintSet r3 = r1.mConstraintSet;
    L33:
        if (r2 != (-1)) goto L35;
        int r10 = r1.mConstraintID;
    L36:
        if (r3 != null) goto L39;
        Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + id + ", dim =" + width + ", " + height);
        return;
    L39:
        this.mCurrentConstraintNumber = r2;
        ConstraintsChangedListener r11 = this.mConstraintsChangedListener;
        if (r11 == null) goto L42;
        r11.preLayoutChange(id, r10);
    L42:
        r3.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener r12 = this.mConstraintsChangedListener;
        if (r12 == null) goto L48;
        r12.postLayoutChange(id, r10);
        return;
    L48:
        return;
    L35:
        r10 = r1.mVariants.get(r2).mConstraintID;
        goto L36
    L32:
        r3 = r1.mVariants.get(r2).mConstraintSet;
        goto L33
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    private void load(Context context, int resourceId) {
        XmlResourceParser r9 = context.getResources().getXml(resourceId);
        int r0 = r9.getEventType();     // Catch: IOException -> L41 XmlPullParserException -> L43
        State r1 = null;
    L4:
        byte r2 = 1;
        if (r0 == 1) goto L58;
        if (r0 != 0) goto L8;
        r9.getName();     // Catch: IOException -> L41 XmlPullParserException -> L43
    L39:
        r0 = r9.next();     // Catch: IOException -> L41 XmlPullParserException -> L43
    L8:
        if (r0 != 2) goto L39;
        String r3 = r9.getName();     // Catch: IOException -> L41 XmlPullParserException -> L43
        switch(r3.hashCode()) {
            case -1349929691: goto L26;
            case 80204913: goto L23;
            case 1382829617: goto L20;
            case 1657696882: goto L17;
            case 1901439077: goto L14;
            default: goto L28;
        };     // Catch: IOException -> L41 XmlPullParserException -> L43
    L28:
        r2 = -1;
    L29:
        if (r2 == 2) goto L37;
        if (r2 == 3) goto L34;
        if (r2 != 4) goto L39;
        parseConstraintSet(context, r9);     // Catch: IOException -> L41 XmlPullParserException -> L43
        goto L39
    L34:
        Variant r4 = new Variant(context, r9);     // Catch: IOException -> L41 XmlPullParserException -> L43
        if (r1 == null) goto L39;
        r1.add(r4);     // Catch: IOException -> L41 XmlPullParserException -> L43
        goto L39
    L37:
        r1 = new State(context, r9);     // Catch: IOException -> L41 XmlPullParserException -> L43
        this.mStateList.put(r1.mId, r1);     // Catch: IOException -> L41 XmlPullParserException -> L43
        goto L39
    L14:
        if (r3.equals("Variant") == false) goto L28;
        r2 = 3;
        goto L29
    L17:
        if (r3.equals("layoutDescription") == false) goto L28;
        r2 = 0;
        goto L29
    L20:
        if (r3.equals("StateSet") == false) goto L28;
    L23:
        if (r3.equals("State") == false) goto L28;
        r2 = 2;
        goto L29
    L26:
        if (r3.equals("ConstraintSet") == false) goto L28;
        r2 = 4;
        goto L29
    L58:
        return;
    L41:
        e = move-exception;
        e.printStackTrace();
        return;
    L43:
        e = move-exception;
        e.printStackTrace();
    }

    private void parseConstraintSet(Context context, XmlPullParser parser) {
        ConstraintSet r0 = new ConstraintSet();
        int r1 = parser.getAttributeCount();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L27;
        String r3 = parser.getAttributeName(r2);
        String r4 = parser.getAttributeValue(r2);
        if (r3 == null) goto L20;
        if (r4 == null) goto L20;
        if ("id".equals(r3) == false) goto L20;
        if (r4.contains(LibrarianImpl.Constants.SEPARATOR) == false) goto L13;
        int r5 = context.getResources().getIdentifier(r4.substring(r4.indexOf(47) + 1), "id", context.getPackageName());
    L14:
        if (r5 == (-1)) goto L16;
    L19:
        r0.load(context, parser);
        this.mConstraintSetMap.put(r5, r0);
        return;
    L16:
        if (r4.length() <= 1) goto L18;
        r5 = Integer.parseInt(r4.substring(1));
        goto L19
    L18:
        Log.e("ConstraintLayoutStates", "error in parsing id");
        goto L19
    L13:
        r5 = -1;
    L20:
        r2 = r2 + 1;
        goto L3
    }
}
