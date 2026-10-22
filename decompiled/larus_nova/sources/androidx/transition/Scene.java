package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes17.dex */
public class Scene {
    private Context mContext;
    private Runnable mEnterAction;
    private Runnable mExitAction;
    private View mLayout;
    private int mLayoutId;
    private ViewGroup mSceneRoot;

    public void enter() {
        if (this.mLayoutId <= 0) goto L5;
    L6:
        getSceneRoot().removeAllViews();
        if (this.mLayoutId <= 0) goto L9;
        LayoutInflater.from(this.mContext).inflate(this.mLayoutId, this.mSceneRoot);
    L10:
        Runnable r100 = this.mEnterAction;
        if (r100 == null) goto L13;
        r100.run();
    L13:
        setCurrentScene(this.mSceneRoot, this);
        return;
    L9:
        this.mSceneRoot.addView(this.mLayout);
        goto L10
    L5:
        if (this.mLayout == null) goto L10;
        goto L6
    }

    public void exit() {
        if (getCurrentScene(this.mSceneRoot) != this) goto L8;
        Runnable r100 = this.mExitAction;
        if (r100 == null) goto L9;
        r100.run();
        return;
    L9:
        return;
    }

    public boolean isCreatedFromLayoutResource() {
        if (this.mLayoutId <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public ViewGroup getSceneRoot() {
        return this.mSceneRoot;
    }

    public Scene(ViewGroup r100) {
        this.mLayoutId = -1;
        this.mSceneRoot = r100;
    }

    public static Scene getCurrentScene(View r100) {
        return (Scene) r100.getTag(R.id.transition_current_scene);
    }

    public void setEnterAction(Runnable r100) {
        this.mEnterAction = r100;
    }

    public void setExitAction(Runnable r100) {
        this.mExitAction = r100;
    }

    public Scene(ViewGroup r100, View r101) {
        this.mLayoutId = -1;
        this.mSceneRoot = r100;
        this.mLayout = r101;
    }

    public static void setCurrentScene(View r100, Scene r101) {
        r100.setTag(R.id.transition_current_scene, r101);
    }

    private Scene(ViewGroup r100, int r101, Context r102) {
        this.mContext = r102;
        this.mSceneRoot = r100;
        this.mLayoutId = r101;
    }

    public static Scene getSceneForLayout(ViewGroup r100, int r101, Context r102) {
        SparseArray r103 = (SparseArray) r100.getTag(R.id.transition_scene_layoutid_cache);
        if (r103 != null) goto L5;
        r103 = new SparseArray();
        r100.setTag(R.id.transition_scene_layoutid_cache, r103);
    L5:
        Scene r104 = (Scene) r103.get(r101);
        if (r104 == null) goto L8;
        return r104;
    L8:
        Scene r105 = new Scene(r100, r101, r102);
        r103.put(r101, r105);
        return r105;
    }
}
