package com.obric.oui.button;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oui.R$attr;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eR*\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/button/OStatefulIconButton;", "Lcom/obric/oui/button/OIconButton;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "extraSpace", "", "onCreateDrawableState", "(I)[I", "", CommonKey.KEY_VALUE, "n", "Z", "isChecked", "()Z", "setChecked", "(Z)V", "o", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OStatefulIconButton extends OIconButton {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f12542o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f12543p = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f12544n;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f12542o = new a(null);
        f12543p = new int[]{R$attr.state_checked};
    }

    @JvmOverloads
    public OStatefulIconButton(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 14, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int r10) {
        int[] r11 = super.onCreateDrawableState(r10 + 1);
        if (this.f12544n == false) goto L5;
        ImageView.mergeDrawableStates(r11, f12543p);
    L5:
        q.f(r11, "drawableState");
        return r11;
    }

    public final void setChecked(boolean r10) {
        if (this.f12544n == r10) goto L6;
        this.f12544n = r10;
        refreshDrawableState();
        return;
    }

    @JvmOverloads
    public OStatefulIconButton(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 12, null);
    }

    @JvmOverloads
    public OStatefulIconButton(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        int r13 = 0;
        this(r10, r11, r12, r13, 8, null);
    }

    public /* synthetic */ OStatefulIconButton(Context r10, AttributeSet r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = 0;
    L11:
        this(r10, r11, r12, r13);
    }

    public OStatefulIconButton(Context r10, AttributeSet r11, int r12, int r13) {
        q.g(r10, "context");
        super(r10, r11, r12, r13, null, 16, null);
    }
}
