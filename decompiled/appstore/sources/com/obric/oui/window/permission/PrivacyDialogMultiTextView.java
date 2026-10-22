package com.obric.oui.window.permission;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/window/permission/PrivacyDialogMultiTextView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/obric/oui/text/OTextView;", "getContentTextView", "()Lcom/obric/oui/text/OTextView;", "a", "Lcom/obric/oui/text/OTextView;", "tvContent", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrivacyDialogMultiTextView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OTextView f17660a;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public PrivacyDialogMultiTextView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @NotNull
    public final OTextView getContentTextView() {
        return this.f17660a;
    }

    public /* synthetic */ PrivacyDialogMultiTextView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public PrivacyDialogMultiTextView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        ViewGroup.inflate(r10, R$layout.o_layout_privacy_dialog_multi_text, this);
        View r12 = findViewById(R$id.tv_content);
        q.f(r12, "findViewById(R.id.tv_content)");
        this.f17660a = (OTextView) r12;
    }
}
