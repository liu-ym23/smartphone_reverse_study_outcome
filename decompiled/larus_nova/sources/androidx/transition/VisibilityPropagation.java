package androidx.transition;

import android.view.View;

/* JADX INFO: loaded from: classes17.dex */
public abstract class VisibilityPropagation extends TransitionPropagation {
    private static final String PROPNAME_VIEW_CENTER = "android:visibilityPropagation:center";
    private static final String PROPNAME_VISIBILITY = "android:visibilityPropagation:visibility";
    private static final String[] VISIBILITY_PROPAGATION_VALUES = null;

    static {
        VISIBILITY_PROPAGATION_VALUES = new String[]{PROPNAME_VISIBILITY, PROPNAME_VIEW_CENTER};
    }

    public VisibilityPropagation() {
    }

    @Override // androidx.transition.TransitionPropagation
    public String[] getPropagationProperties() {
        return VISIBILITY_PROPAGATION_VALUES;
    }

    @Override // androidx.transition.TransitionPropagation
    public void captureValues(TransitionValues r100) {
        View r101 = r100.view;
        Integer r102 = (Integer) r100.values.get("android:visibility:visibility");
        if (r102 != null) goto L5;
        r102 = Integer.valueOf(r101.getVisibility());
    L5:
        r100.values.put(PROPNAME_VISIBILITY, r102);
        int[] r103 = {r4, 0};
        r101.getLocationOnScreen(r103);
        int r104 = r103[0] + Math.round(r101.getTranslationX());
        r103[0] = r104 + (r101.getWidth() / 2);
        int r105 = r103[1] + Math.round(r101.getTranslationY());
        r103[1] = r105;
        r103[1] = r105 + (r101.getHeight() / 2);
        r100.values.put(PROPNAME_VIEW_CENTER, r103);
    }

    public int getViewVisibility(TransitionValues r100) {
        if (r100 != null) goto L5;
        return 8;
    L5:
        Integer r101 = (Integer) r100.values.get(PROPNAME_VISIBILITY);
        if (r101 != null) goto L9;
        return 8;
    L9:
        return r101.intValue();
    }

    public int getViewX(TransitionValues r100) {
        return getViewCoordinate(r100, 0);
    }

    public int getViewY(TransitionValues r100) {
        return getViewCoordinate(r100, 1);
    }

    private static int getViewCoordinate(TransitionValues r100, int r101) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        int[] r102 = (int[]) r100.values.get(PROPNAME_VIEW_CENTER);
        if (r102 != null) goto L9;
        return -1;
    L9:
        return r102[r101];
    }
}
