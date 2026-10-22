package androidx.constraintlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.Xml;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes17.dex */
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

    public static class State {
        int mConstraintID;
        ConstraintSet mConstraintSet;
        int mId;
        ArrayList<Variant> mVariants;

        public void add(Variant r100) {
            this.mVariants.add(r100);
        }

        public State(Context r100, XmlPullParser r101) {
            this.mVariants = new ArrayList();
            this.mConstraintID = -1;
            TypedArray r102 = r100.obtainStyledAttributes(Xml.asAttributeSet(r101), new int[]{R.attr.id, com.larus.nova.R.attr.constraints});
            int r103 = r102.getIndexCount();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L13;
            int r105 = r102.getIndex(r104);
            if (r105 != 0) goto L8;
            this.mId = r102.getResourceId(r105, this.mId);
        L12:
            r104 = r104 + 1;
            goto L3
        L8:
            if (r105 != 1) goto L12;
            this.mConstraintID = r102.getResourceId(r105, this.mConstraintID);
            String r106 = r100.getResources().getResourceTypeName(this.mConstraintID);
            r100.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r106) == false) goto L12;
            ConstraintSet r107 = new ConstraintSet();
            this.mConstraintSet = r107;
            r107.clone(r100, this.mConstraintID);
            goto L12
        L13:
            r102.recycle();
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
        ConstraintSet mConstraintSet;
        int mId;
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
            TypedArray r102 = r100.obtainStyledAttributes(Xml.asAttributeSet(r101), new int[]{com.larus.nova.R.attr.constraints, com.larus.nova.R.attr.region_heightLessThan, com.larus.nova.R.attr.region_heightMoreThan, com.larus.nova.R.attr.region_widthLessThan, com.larus.nova.R.attr.region_widthMoreThan});
            int r103 = r102.getIndexCount();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L22;
            int r105 = r102.getIndex(r104);
            if (r105 != 0) goto L10;
            this.mConstraintID = r102.getResourceId(r105, this.mConstraintID);
            String r106 = r100.getResources().getResourceTypeName(this.mConstraintID);
            r100.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r106) == false) goto L21;
            ConstraintSet r107 = new ConstraintSet();
            this.mConstraintSet = r107;
            r107.clone(r100, this.mConstraintID);
        L21:
            r104 = r104 + 1;
            goto L3
        L10:
            if (r105 != 1) goto L13;
            this.mMaxHeight = r102.getDimension(r105, this.mMaxHeight);
            goto L21
        L13:
            if (r105 != 2) goto L16;
            this.mMinHeight = r102.getDimension(r105, this.mMinHeight);
            goto L21
        L16:
            if (r105 != 3) goto L19;
            this.mMaxWidth = r102.getDimension(r105, this.mMaxWidth);
            goto L21
        L19:
            if (r105 != 4) goto L21;
            this.mMinWidth = r102.getDimension(r105, this.mMinWidth);
            goto L21
        L22:
            r102.recycle();
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

    private void load(Context r100, int r101) {
        XmlResourceParser r102 = r100.getResources().getXml(r101);
        int r103 = r102.getEventType();     // Catch: IOException -> L43 XmlPullParserException -> L45
        State r104 = null;
    L5:
        if (r103 == 1) goto L62;
        if (r103 != 0) goto L8;
        r102.getName();     // Catch: IOException -> L43 XmlPullParserException -> L45
    L41:
        r103 = r102.next();     // Catch: IOException -> L43 XmlPullParserException -> L45
    L8:
        if (r103 != 2) goto L41;
        String r105 = r102.getName();     // Catch: IOException -> L43 XmlPullParserException -> L45
        switch(r105.hashCode()) {
            case -1349929691: goto L26;
            case 80204913: goto L23;
            case 1382829617: goto L20;
            case 1657696882: goto L17;
            case 1901439077: goto L14;
            default: goto L28;
        };     // Catch: IOException -> L43 XmlPullParserException -> L45
    L28:
        byte r106 = -1;
    L29:
        if (r106 == 0) goto L41;
        if (r106 == 1) goto L41;
        if (r106 == 2) goto L39;
        if (r106 == 3) goto L36;
        if (r106 != 4) goto L41;
        parseConstraintSet(r100, r102);     // Catch: IOException -> L43 XmlPullParserException -> L45
        goto L41
    L36:
        Variant r107 = new Variant(r100, r102);     // Catch: IOException -> L43 XmlPullParserException -> L45
        if (r104 == null) goto L41;
        r104.add(r107);     // Catch: IOException -> L43 XmlPullParserException -> L45
        goto L41
    L39:
        r104 = new State(r100, r102);     // Catch: IOException -> L43 XmlPullParserException -> L45
        this.mStateList.put(r104.mId, r104);     // Catch: IOException -> L43 XmlPullParserException -> L45
        goto L41
    L14:
        if (r105.equals("Variant") == false) goto L28;
        r106 = 3;
        goto L29
    L17:
        if (r105.equals("layoutDescription") == false) goto L28;
        r106 = 0;
        goto L29
    L20:
        if (r105.equals("StateSet") == false) goto L28;
        r106 = 1;
        goto L29
    L23:
        if (r105.equals("State") == false) goto L28;
        r106 = 2;
        goto L29
    L26:
        if (r105.equals("ConstraintSet") == false) goto L28;
        r106 = 4;
        goto L29
    L62:
        return;
    L43:
        e = move-exception;
        e.printStackTrace();
        return;
    L45:
        e = move-exception;
        e.printStackTrace();
    }

    private void parseConstraintSet(Context r100, XmlPullParser r110) {
        ConstraintSet r101 = new ConstraintSet();
        int r102 = r110.getAttributeCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L19;
        if ("id".equals(r110.getAttributeName(r103)) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        String r104 = r110.getAttributeValue(r103);
        if (r104.contains(HTTP.URL_DEFAULT) == false) goto L9;
        String r105 = r104.substring(r104.indexOf(47) + 1);
        int r106 = r100.getResources().getIdentifier(r105, "id", r100.getPackageName());
    L10:
        if (r106 == (-1)) goto L12;
    L14:
        r101.load(r100, r110);
        this.mConstraintSetMap.put(r106, r101);
        return;
    L12:
        if (r104.length() <= 1) goto L14;
        r106 = CastIntegerProtector.parseInt(r104.substring(1));
        goto L14
    L9:
        r106 = -1;
        goto L10
    }

    public ConstraintLayoutStates(Context r100, ConstraintLayout r101, int r102) {
        this.mCurrentStateId = -1;
        this.mCurrentConstraintNumber = -1;
        this.mStateList = new SparseArray();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintsChangedListener = null;
        this.mConstraintLayout = r101;
        load(r100, r102);
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

    public void updateConstraints(int r100, float r101, float r102) {
        int r103 = this.mCurrentStateId;
        if (r103 != r100) goto L29;
        if (r100 != (-1)) goto L6;
        State r104 = this.mStateList.valueAt(0);
    L7:
        int r105 = this.mCurrentConstraintNumber;
        if (r105 != (-1)) goto L10;
    L12:
        int r106 = r104.findMatch(r101, r102);
        if (this.mCurrentConstraintNumber != r106) goto L15;
        return;
    L15:
        if (r106 != (-1)) goto L17;
        ConstraintSet r107 = this.mDefaultConstraintSet;
    L18:
        if (r106 != (-1)) goto L20;
        int r108 = r104.mConstraintID;
    L21:
        if (r107 != null) goto L23;
        return;
    L23:
        this.mCurrentConstraintNumber = r106;
        ConstraintsChangedListener r109 = this.mConstraintsChangedListener;
        if (r109 == null) goto L26;
        r109.preLayoutChange(-1, r108);
    L26:
        r107.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener r110 = this.mConstraintsChangedListener;
        if (r110 == null) goto L46;
        r110.postLayoutChange(-1, r108);
        return;
    L46:
        return;
    L20:
        r108 = ((Variant) ListProtector.get(r104.mVariants, r106)).mConstraintID;
        goto L21
    L17:
        r107 = ((Variant) ListProtector.get(r104.mVariants, r106)).mConstraintSet;
        goto L18
    L10:
        if (((Variant) ListProtector.get(r104.mVariants, r105)).match(r101, r102) == false) goto L12;
        return;
    L6:
        r104 = this.mStateList.get(r103);
        goto L7
    L29:
        this.mCurrentStateId = r100;
        State r111 = this.mStateList.get(r100);
        int r112 = r111.findMatch(r101, r102);
        if (r112 != (-1)) goto L32;
        ConstraintSet r113 = r111.mConstraintSet;
    L33:
        if (r112 != (-1)) goto L35;
        int r114 = r111.mConstraintID;
    L36:
        if (r113 == null) goto L38;
        this.mCurrentConstraintNumber = r112;
        ConstraintsChangedListener r115 = this.mConstraintsChangedListener;
        if (r115 == null) goto L42;
        r115.preLayoutChange(r100, r114);
    L42:
        r113.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener r116 = this.mConstraintsChangedListener;
        if (r116 == null) goto L48;
        r116.postLayoutChange(r100, r114);
        return;
    L48:
        return;
    L38:
        return;
    L35:
        r114 = ((Variant) ListProtector.get(r111.mVariants, r112)).mConstraintID;
        goto L36
    L32:
        r113 = ((Variant) ListProtector.get(r111.mVariants, r112)).mConstraintSet;
        goto L33
    }
}
