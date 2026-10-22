package com.bytedance.android.livesdk.interactivity.barrage.view;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.livesdk.chatroom.ui.StrokeTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/view/StrokeColorTextView;", "Lcom/bytedance/android/livesdk/chatroom/ui/StrokeTextView;", "", "color", "", "setTextColor", "setStrokeColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StrokeColorTextView extends StrokeTextView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearGradient f134052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearGradient f134053g;

    public StrokeColorTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StrokeColorTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setStrokeColor(int r100) {
        AppCompatTextView r101 = getOutlineTextView();
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    @Override // android.widget.TextView
    public void setTextColor(int r100) {
        this.f134052f = null;
        getPaint().setShader(null);
        super.setTextColor(r100);
    }

    public final void y(int r110, int r111) {
        this.f134052f = new LinearGradient(0.0f, 1.0f, getPaint().measureText(getText(), 0, getText().length()), 1.0f, r110, r111, Shader.TileMode.CLAMP);
        getPaint().setShader(this.f134052f);
        invalidate();
    }

    public final void z(int[] r110, float[] r111) {
        Intrinsics.checkNotNullParameter(r110, "intArray");
        Intrinsics.checkNotNullParameter(r111, "position");
        this.f134052f = new LinearGradient(0.0f, 0.0f, getPaint().measureText(getText(), 0, getText().length()), 0.0f, r110, r111, Shader.TileMode.CLAMP);
        getPaint().setShader(this.f134052f);
        invalidate();
    }

    public StrokeColorTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ StrokeColorTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
