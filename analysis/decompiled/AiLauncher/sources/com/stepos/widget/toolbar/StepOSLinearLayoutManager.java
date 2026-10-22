package com.stepos.widget.toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u000eJ\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/widget/toolbar/StepOSLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroid/content/Context;", "context", "", "orientation", "", "reverseLayout", "<init>", "(Landroid/content/Context;IZ)V", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Landroidx/recyclerview/widget/RecyclerView$State;", VoiceWakeupReceiver.EXTRA_STATE, "", "extraLayoutSpace", "LY8/t;", "calculateExtraLayoutSpace", "(Landroidx/recyclerview/widget/RecyclerView$State;[I)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSLinearLayoutManager extends LinearLayoutManager {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"WrongConstant"})
    public StepOSLinearLayoutManager(Context context) {
        this(context, 0, false, 6, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void calculateExtraLayoutSpace(RecyclerView.State state, int[] extraLayoutSpace) {
        kotlin.jvm.internal.p.i(state, "state");
        kotlin.jvm.internal.p.i(extraLayoutSpace, "extraLayoutSpace");
        super.calculateExtraLayoutSpace(state, extraLayoutSpace);
        if (getOrientation() == 1) {
            extraLayoutSpace[0] = Math.max(extraLayoutSpace[0], getPaddingTop());
            extraLayoutSpace[1] = Math.max(extraLayoutSpace[1], getPaddingBottom());
        } else {
            extraLayoutSpace[0] = Math.max(extraLayoutSpace[0], getPaddingStart());
            extraLayoutSpace[1] = Math.max(extraLayoutSpace[1], getPaddingEnd());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"WrongConstant"})
    public StepOSLinearLayoutManager(Context context, int i10) {
        this(context, i10, false, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public /* synthetic */ StepOSLinearLayoutManager(Context context, int i10, boolean z10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? 1 : i10, (i11 & 4) != 0 ? false : z10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"WrongConstant"})
    public StepOSLinearLayoutManager(Context context, int i10, boolean z10) {
        super(context, i10, z10);
        kotlin.jvm.internal.p.i(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSLinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.p.i(context, "context");
    }
}
