package androidx.transition;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class GhostViewHolder extends FrameLayout {
    private boolean mAttached;
    private ViewGroup mParent;

    GhostViewHolder(ViewGroup r4) {
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        setClipChildren(false);
        this.mParent = r4;
        r4.setTag(ZeusTransformUtils.mapRes(R.id.ghost_view_holder, DbHelper.COL_ID, "ghost_view_holder"), this);
        ab.a(this.mParent).a(this);
        this.mAttached = true;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r2) {
        if (this.mAttached == false) goto L7;
        super.onViewAdded(r2);
        return;
    L7:
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r5) {
        super.onViewRemoved(r5);
        if (getChildCount() != 1) goto L7;
        if (getChildAt(0) != r5) goto L7;
    L8:
        this.mParent.setTag(ZeusTransformUtils.mapRes(R.id.ghost_view_holder, DbHelper.COL_ID, "ghost_view_holder"), null);
        ab.a(this.mParent).b(this);
        this.mAttached = false;
        return;
    L7:
        if (getChildCount() == 0) goto L8;
    }

    static GhostViewHolder getHolder(ViewGroup r3) {
        return (GhostViewHolder) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(R.id.ghost_view_holder, DbHelper.COL_ID, "ghost_view_holder")), GhostViewHolder.class, "com.obric.aiagent.plugin");
    }

    void popToOverlayTop() {
        if (this.mAttached == false) goto L7;
        ab.a(this.mParent).b(this);
        ab.a(this.mParent).a(this);
        return;
    L7:
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    void addGhostView(GhostViewPort r3) {
        ArrayList<View> r0 = new ArrayList();
        getParents(r3.mView, r0);
        int r1 = getInsertIndex(r0);
        if (r1 >= 0) goto L5;
    L8:
        addView(r3);
        return;
    L5:
        if (r1 >= getChildCount()) goto L8;
        addView(r3, r1);
    }

    private int getInsertIndex(ArrayList<View> r8) {
        ArrayList r0 = new ArrayList();
        int r1 = getChildCount() - 1;
        int r2 = 0;
    L3:
        if (r2 > r1) goto L9;
        int r3 = (r2 + r1) / 2;
        getParents(((GhostViewPort) ZeusTransformUtils.preCheckCast(getChildAt(r3), GhostViewPort.class, "com.obric.aiagent.plugin")).mView, r0);
        if (isOnTop(r8, r0) == false) goto L7;
        r2 = r3 + 1;
    L8:
        r0.clear();
        goto L3
    L7:
        r1 = r3 - 1;
        goto L8
    L9:
        return r2;
    }

    private static boolean isOnTop(ArrayList<View> r8, ArrayList<View> r9) {
        if (r8.isEmpty() == false) goto L5;
        return true;
    L5:
        if (r9.isEmpty() == false) goto L7;
        return true;
    L7:
        if (r8.get(0) != r9.get(0)) goto L25;
        int r2 = Math.min(r8.size(), r9.size());
        int r3 = 1;
    L10:
        if (r3 >= r2) goto L17;
        View r4 = (View) ZeusTransformUtils.preCheckCast(r8.get(r3), View.class, "com.obric.aiagent.plugin");
        View r5 = (View) ZeusTransformUtils.preCheckCast(r9.get(r3), View.class, "com.obric.aiagent.plugin");
        if (r4 != r5) goto L14;
        r3 = r3 + 1;
        goto L10
    L14:
        return isOnTop(r4, r5);
    L17:
        if (r9.size() != r2) goto L20;
        return true;
    L20:
        return false;
    L25:
        return true;
    }

    private static void getParents(View r3, ArrayList<View> r4) {
        ViewParent r0 = r3.getParent();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.class) == false) goto L5;
        getParents((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), r4);
    L5:
        r4.add(r3);
    }

    private static boolean isOnTop(View r6, View r7) {
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(r6.getParent(), ViewGroup.class, "com.obric.aiagent.plugin");
        int r1 = r0.getChildCount();
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L10:
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L19;
        View r5 = r0.getChildAt(ab.a(r0, r2));
        if (r5 == r6) goto L24;
        if (r5 == r7) goto L19;
        r2 = r2 + 1;
        goto L11
    L24:
        return false;
    L19:
        return true;
    L5:
        if (r6.getZ() == r7.getZ()) goto L10;
        if (r6.getZ() > r7.getZ()) goto L9;
        return false;
    L9:
        return true;
    }
}
