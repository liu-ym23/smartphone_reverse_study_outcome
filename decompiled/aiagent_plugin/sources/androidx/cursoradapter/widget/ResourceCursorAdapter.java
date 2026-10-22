package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class ResourceCursorAdapter extends CursorAdapter {
    private int mDropDownLayout;
    private LayoutInflater mInflater;
    private int mLayout;

    @Deprecated
    public ResourceCursorAdapter(Context r3, int r4, Cursor r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super(r6, (Cursor) ZeusTransformUtils.wrapperContextForParams(r5, Cursor.class, "com.obric.aiagent.plugin"));
        this.mDropDownLayout = r4;
        this.mLayout = r4;
        this.mInflater = (LayoutInflater) ZeusTransformUtils.preCheckCast(r6.getSystemService("layout_inflater"), LayoutInflater.class, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public ResourceCursorAdapter(Context r3, int r4, Cursor r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super(r7, (Cursor) ZeusTransformUtils.wrapperContextForParams(r5, Cursor.class, "com.obric.aiagent.plugin"), r6);
        this.mDropDownLayout = r4;
        this.mLayout = r4;
        this.mInflater = (LayoutInflater) ZeusTransformUtils.preCheckCast(r7.getSystemService("layout_inflater"), LayoutInflater.class, "com.obric.aiagent.plugin");
    }

    public ResourceCursorAdapter(Context r3, int r4, Cursor r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super(r7, (Cursor) ZeusTransformUtils.wrapperContextForParams(r5, Cursor.class, "com.obric.aiagent.plugin"), r6);
        this.mDropDownLayout = r4;
        this.mLayout = r4;
        this.mInflater = (LayoutInflater) ZeusTransformUtils.preCheckCast(r7.getSystemService("layout_inflater"), LayoutInflater.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context r3, Cursor r4, ViewGroup r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Cursor r7 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.aiagent.plugin");
        return ZeusTransformUtils.inflate(this.mInflater, this.mLayout, r5, false, "com.obric.aiagent.plugin");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newDropDownView(Context r3, Cursor r4, ViewGroup r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Cursor r7 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.aiagent.plugin");
        return ZeusTransformUtils.inflate(this.mInflater, this.mDropDownLayout, r5, false, "com.obric.aiagent.plugin");
    }

    public void setViewResource(int r1) {
        this.mLayout = r1;
    }

    public void setDropDownViewResource(int r1) {
        this.mDropDownLayout = r1;
    }
}
