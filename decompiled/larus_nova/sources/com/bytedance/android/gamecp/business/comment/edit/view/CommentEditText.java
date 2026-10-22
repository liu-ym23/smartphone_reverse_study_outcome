package com.bytedance.android.gamecp.business.comment.edit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u0013\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bB\u001d\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\n\u0010\u000eB%\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\n\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/edit/view/CommentEditText;", "Landroid/widget/EditText;", "Lcom/bytedance/android/gamecp/business/comment/edit/view/a$a;", "listener", "", "setOnBackKeyListener", "Lcom/bytedance/android/gamecp/business/comment/edit/view/CommentEditText$a;", "setOnSelectionChangeListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentEditText extends EditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f52200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.comment.edit.view.a f52201b;

    public interface a {
        void a(int r100, int r101);
    }

    public CommentEditText(Context r100) {
        super(r100);
        this.f52201b = new com.bytedance.android.gamecp.business.comment.edit.view.a();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r100) {
        this.f52201b.setTarget(super.onCreateInputConnection(r100));
        return this.f52201b;
    }

    public final void setOnBackKeyListener(com.bytedance.android.gamecp.business.comment.edit.view.a.InterfaceC0876a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.bytedance.android.gamecp.business.comment.edit.view.a r101 = this.f52201b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        r101.f52210a = r100;
    }

    public final void setOnSelectionChangeListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f52200a = r100;
    }

    public CommentEditText(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f52201b = new com.bytedance.android.gamecp.business.comment.edit.view.a();
    }

    @Override // android.widget.TextView
    public final void onSelectionChanged(int r100, int r101) {
        super.onSelectionChanged(r100, r101);
        a r102 = this.f52200a;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    public CommentEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f52201b = new com.bytedance.android.gamecp.business.comment.edit.view.a();
    }
}
