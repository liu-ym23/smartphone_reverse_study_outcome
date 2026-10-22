package androidx.constraintlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.SparseArray;
import android.util.Xml;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes17.dex */
public class StateSet {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private SparseArray<ConstraintSet> mConstraintSetMap;
    private ConstraintsChangedListener mConstraintsChangedListener;
    int mCurrentConstraintNumber;
    int mCurrentStateId;
    ConstraintSet mDefaultConstraintSet;
    int mDefaultState;
    private SparseArray<State> mStateList;

    public static class State {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
        ArrayList<Variant> mVariants;

        public void add(Variant r100) {
            this.mVariants.add(r100);
        }

        public State(Context r100, XmlPullParser r101) {
            this.mVariants = new ArrayList();
            this.mConstraintID = -1;
            int r102 = 0;
            this.mIsLayout = false;
            TypedArray r103 = r100.obtainStyledAttributes(Xml.asAttributeSet(r101), new int[]{R.attr.id, com.larus.nova.R.attr.constraints});
            int r104 = r103.getIndexCount();
        L3:
            if (r102 >= r104) goto L13;
            int r105 = r103.getIndex(r102);
            if (r105 != 0) goto L8;
            this.mId = r103.getResourceId(r105, this.mId);
        L12:
            r102 = r102 + 1;
            goto L3
        L8:
            if (r105 != 1) goto L12;
            this.mConstraintID = r103.getResourceId(r105, this.mConstraintID);
            String r106 = r100.getResources().getResourceTypeName(this.mConstraintID);
            r100.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r106) == false) goto L12;
            this.mIsLayout = true;
            goto L12
        L13:
            r103.recycle();
        }

        public int findMatch(float r100, float r101) {
            int r102 = 0;
        L4:
            if (r102 >= this.mVariants.size()) goto L9;
            if (((Variant) ListProtector.get(this.mVariants, r102)).match(r100, r101) == true) goto L7;
            r102 = r102 + 1;
            goto L4
        L7:
            return r102;
        L9:
            return -1;
        }
    }

    public static class Variant {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
        float mMaxHeight;
        float mMaxWidth;
        float mMinHeight;
        float mMinWidth;

        public Variant(Context r100, XmlPullParser r101) {
            this.mMinWidth = Float.NaN;
            this.mMinHeight = Float.NaN;
            this.mMaxWidth = Float.NaN;
            this.mMaxHeight = Float.NaN;
            this.mConstraintID = -1;
            int r102 = 0;
            this.mIsLayout = false;
            TypedArray r103 = r100.obtainStyledAttributes(Xml.asAttributeSet(r101), new int[]{com.larus.nova.R.attr.constraints, com.larus.nova.R.attr.region_heightLessThan, com.larus.nova.R.attr.region_heightMoreThan, com.larus.nova.R.attr.region_widthLessThan, com.larus.nova.R.attr.region_widthMoreThan});
            int r104 = r103.getIndexCount();
        L3:
            if (r102 >= r104) goto L21;
            int r105 = r103.getIndex(r102);
            if (r105 != 0) goto L9;
            this.mConstraintID = r103.getResourceId(r105, this.mConstraintID);
            String r106 = r100.getResources().getResourceTypeName(this.mConstraintID);
            r100.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r106) == false) goto L20;
            this.mIsLayout = true;
        L20:
            r102 = r102 + 1;
            goto L3
        L9:
            if (r105 != 1) goto L12;
            this.mMaxHeight = r103.getDimension(r105, this.mMaxHeight);
            goto L20
        L12:
            if (r105 != 2) goto L15;
            this.mMinHeight = r103.getDimension(r105, this.mMinHeight);
            goto L20
        L15:
            if (r105 != 3) goto L18;
            this.mMaxWidth = r103.getDimension(r105, this.mMaxWidth);
            goto L20
        L18:
            if (r105 != 4) goto L20;
            this.mMinWidth = r103.getDimension(r105, this.mMinWidth);
            goto L20
        L21:
            r103.recycle();
        }

        public boolean match(float r100, float r101) {
            if (Float.isNaN(this.mMinWidth) == true) goto L8;
            if (r100 >= this.mMinWidth) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.mMinHeight) == true) goto L13;
            if (r101 >= this.mMinHeight) goto L13;
            return false;
        L13:
            if (Float.isNaN(this.mMaxWidth) == true) goto L18;
            if (r100 <= this.mMaxWidth) goto L18;
            return false;
        L18:
            if (Float.isNaN(this.mMaxHeight) == false) goto L20;
            return true;
        L20:
            if (r101 <= this.mMaxHeight) goto L24;
            return false;
        L24:
            return true;
        }
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener r100) {
        this.mConstraintsChangedListener = r100;
    }

    public StateSet(Context r100, XmlPullParser r101) {
        this.mDefaultState = -1;
        this.mCurrentStateId = -1;
        this.mCurrentConstraintNumber = -1;
        this.mStateList = new SparseArray();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintsChangedListener = null;
        load(r100, r101);
    }

    private void load(Context r100, XmlPullParser r110) {
        TypedArray r101 = r100.obtainStyledAttributes(Xml.asAttributeSet(r110), new int[]{com.larus.nova.R.attr.defaultState});
        int r102 = r101.getIndexCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        int r104 = r101.getIndex(r103);
        if (r104 != 0) goto L7;
        this.mDefaultState = r101.getResourceId(r104, this.mDefaultState);
    L7:
        r103 = r103 + 1;
        goto L3
    L8:
        r101.recycle();
        int r105 = r110.getEventType();     // Catch: IOException -> L48 XmlPullParserException -> L50
        State r106 = null;
    L11:
        if (r105 == 1) goto L70;
        if (r105 != 0) goto L14;
        r110.getName();     // Catch: IOException -> L48 XmlPullParserException -> L50
    L46:
        r105 = r110.next();     // Catch: IOException -> L48 XmlPullParserException -> L50
        goto L11
    L14:
        if (r105 == 2) goto L20;
        if (r105 != 3) goto L46;
        if ("StateSet".equals(r110.getName()) == false) goto L46;
        return;
    L20:
        String r107 = r110.getName();     // Catch: IOException -> L48 XmlPullParserException -> L50
        switch(r107.hashCode()) {
            case 80204913: goto L33;
            case 1301459538: goto L30;
            case 1382829617: goto L27;
            case 1901439077: goto L24;
            default: goto L35;
        };     // Catch: IOException -> L48 XmlPullParserException -> L50
    L35:
        byte r108 = -1;
    L36:
        if (r108 == 0) goto L46;
        if (r108 == 1) goto L46;
        if (r108 == 2) goto L44;
        if (r108 != 3) goto L46;
        Variant r109 = new Variant(r100, r110);     // Catch: IOException -> L48 XmlPullParserException -> L50
        if (r106 == null) goto L46;
        r106.add(r109);     // Catch: IOException -> L48 XmlPullParserException -> L50
        goto L46
    L44:
        r106 = new State(r100, r110);     // Catch: IOException -> L48 XmlPullParserException -> L50
        this.mStateList.put(r106.mId, r106);     // Catch: IOException -> L48 XmlPullParserException -> L50
        goto L46
    L24:
        if (r107.equals("Variant") == false) goto L35;
        r108 = 3;
        goto L36
    L27:
        if (r107.equals("StateSet") == false) goto L35;
        r108 = 1;
        goto L36
    L30:
        if (r107.equals("LayoutDescription") == false) goto L35;
        r108 = 0;
        goto L36
    L33:
        if (r107.equals("State") == false) goto L35;
        r108 = 2;
        goto L36
    L70:
        return;
    L48:
        e = move-exception;
        e.printStackTrace();
        return;
    L50:
        e = move-exception;
        e.printStackTrace();
    }

    public boolean needsToChange(int r100, float r101, float r102) {
        int r103 = this.mCurrentStateId;
        if (r103 == r100) goto L6;
        return true;
    L6:
        if (r100 != (-1)) goto L8;
        State r104 = this.mStateList.valueAt(0);
    L9:
        State r105 = r104;
        int r106 = this.mCurrentConstraintNumber;
        if (r106 == (-1)) goto L15;
        if (((Variant) ListProtector.get(r105.mVariants, r106)).match(r101, r102) == false) goto L15;
        return false;
    L15:
        if (this.mCurrentConstraintNumber != r105.findMatch(r101, r102)) goto L17;
        return false;
    L17:
        return true;
    L8:
        r104 = this.mStateList.get(r103);
        goto L9
    }

    public int stateGetConstraintID(int r100, int r101, int r102) {
        return updateConstraints(-1, r100, r101, r102);
    }

    public int convertToConstraintSet(int r100, int r101, float r102, float r103) {
        State r104 = this.mStateList.get(r101);
        if (r104 != null) goto L6;
        return r101;
    L6:
        if (r102 == (-1.0f)) goto L25;
        if (r103 == (-1.0f)) goto L25;
        Iterator<Variant> r105 = r104.mVariants.iterator();
        Variant r106 = null;
    L12:
        if (r105.hasNext() == false) goto L19;
        Variant r107 = r105.next();
        if (r107.match(r102, r103) == false) goto L12;
        if (r100 == r107.mConstraintID) goto L17;
        r106 = r107;
        goto L12
    L17:
        return r100;
    L19:
        if (r106 == null) goto L23;
        return r106.mConstraintID;
    L23:
        return r104.mConstraintID;
    L25:
        if (r104.mConstraintID != r100) goto L27;
        return r100;
    L27:
        Iterator<Variant> r108 = r104.mVariants.iterator();
    L29:
        if (r108.hasNext() == false) goto L34;
        if (r100 != r108.next().mConstraintID) goto L29;
        return r100;
    L34:
        return r104.mConstraintID;
    }

    public int updateConstraints(int r100, int r101, float r102, float r103) {
        if (r100 != r101) goto L21;
        if (r101 != (-1)) goto L6;
        State r104 = this.mStateList.valueAt(0);
    L7:
        if (r104 != null) goto L10;
        return -1;
    L10:
        if (this.mCurrentConstraintNumber != (-1)) goto L12;
    L14:
        int r105 = r104.findMatch(r102, r103);
        if (r100 != r105) goto L17;
        return r100;
    L17:
        if (r105 != (-1)) goto L20;
        return r104.mConstraintID;
    L20:
        return ((Variant) ListProtector.get(r104.mVariants, r105)).mConstraintID;
    L12:
        if (((Variant) ListProtector.get(r104.mVariants, r100)).match(r102, r103) == false) goto L14;
        return r100;
    L6:
        r104 = this.mStateList.get(this.mCurrentStateId);
        goto L7
    L21:
        State r106 = this.mStateList.get(r101);
        if (r106 != null) goto L24;
        return -1;
    L24:
        int r107 = r106.findMatch(r102, r103);
        if (r107 != (-1)) goto L28;
        return r106.mConstraintID;
    L28:
        return ((Variant) ListProtector.get(r106.mVariants, r107)).mConstraintID;
    }
}
