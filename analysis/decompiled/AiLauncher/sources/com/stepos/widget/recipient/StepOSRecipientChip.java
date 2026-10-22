package com.stepos.widget.recipient;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatTextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\n2\b\b\u0001\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\fJ\u000f\u0010\u001a\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010#\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J)\u0010(\u001a\u00020\n2\b\b\u0001\u0010%\u001a\u00020\u00062\b\b\u0001\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0013¢\u0006\u0004\b(\u0010)J1\u0010(\u001a\u00020\n2\b\b\u0001\u0010%\u001a\u00020\u00062\b\b\u0001\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u0013¢\u0006\u0004\b(\u0010+R\u0016\u0010-\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b-\u0010.R.\u00100\u001a\u0004\u0018\u00010,2\b\u0010/\u001a\u0004\u0018\u00010,8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010.\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u00105R\u0016\u0010*\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u00105¨\u00066"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientChip;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "applyChipMetrics", "()V", "Lcom/stepos/widget/recipient/StepOSRecipientEdit;", "findRecipientEdit", "()Lcom/stepos/widget/recipient/StepOSRecipientEdit;", "resId", "setTextAppearance", "(I)V", "", "dragged", "setDragState", "(Z)V", "isDragState", "()Z", "updateText", "onCheckIsTextEditor", "Landroid/view/inputmethod/EditorInfo;", "outAttrs", "Landroid/view/inputmethod/InputConnection;", "onCreateInputConnection", "(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;", "keyCode", "Landroid/view/KeyEvent;", "event", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "textColor", "pillColor", "selected", "applyColors", "(IIZ)V", "drawBackground", "(IIZZ)V", "", Const.JSON_KEY_ADDRESS, "Ljava/lang/String;", UxipConstants.f30680s, "contactName", "getContactName", "()Ljava/lang/String;", "setContactName", "(Ljava/lang/String;)V", "Z", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSRecipientChip extends AppCompatTextView {
    public String address;
    private String contactName;
    private boolean dragged;
    private boolean drawBackground;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSRecipientChip(Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    private final void applyChipMetrics() throws Resources.NotFoundException {
        setMinWidth(0);
        setMinimumWidth(0);
        setMinEms(0);
        int dimensionPixelSize = this.drawBackground ? getResources().getDimensionPixelSize(R.dimen.stepos_recipient_chip_padding_horizontal) : 0;
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.stepos_recipient_chip_padding_vertical);
        setPaddingRelative(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StepOSRecipientEdit findRecipientEdit() {
        Object parent = getParent();
        while (parent != null) {
            if (parent instanceof StepOSRecipientEdit) {
                return (StepOSRecipientEdit) parent;
            }
            parent = parent instanceof View ? ((View) parent).getParent() : null;
        }
        return null;
    }

    public final void applyColors(int textColor, int pillColor, boolean selected) throws Resources.NotFoundException {
        applyColors(textColor, pillColor, selected, false);
    }

    public final String getContactName() {
        return this.contactName;
    }

    /* renamed from: isDragState, reason: from getter */
    public final boolean getDragged() {
        return this.dragged;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onCheckIsTextEditor() {
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        kotlin.jvm.internal.p.i(outAttrs, "outAttrs");
        outAttrs.inputType = 33;
        outAttrs.imeOptions = 301989888;
        return new BaseInputConnection() { // from class: com.stepos.widget.recipient.StepOSRecipientChip.onCreateInputConnection.1
            {
                super(StepOSRecipientChip.this, false);
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public boolean deleteSurroundingText(int beforeLength, int afterLength) {
                StepOSRecipientEdit stepOSRecipientEditFindRecipientEdit = StepOSRecipientChip.this.findRecipientEdit();
                return stepOSRecipientEditFindRecipientEdit != null && stepOSRecipientEditFindRecipientEdit.onImeDeleteFromChip$StepOSWidget_release();
            }

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public boolean deleteSurroundingTextInCodePoints(int beforeLength, int afterLength) {
                StepOSRecipientEdit stepOSRecipientEditFindRecipientEdit = StepOSRecipientChip.this.findRecipientEdit();
                return stepOSRecipientEditFindRecipientEdit != null && stepOSRecipientEditFindRecipientEdit.onImeDeleteFromChip$StepOSWidget_release();
            }
        };
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        if (keyCode != 67 && keyCode != 112) {
            return super.onKeyDown(keyCode, event);
        }
        StepOSRecipientEdit stepOSRecipientEditFindRecipientEdit = findRecipientEdit();
        return stepOSRecipientEditFindRecipientEdit != null && stepOSRecipientEditFindRecipientEdit.onImeDeleteFromChip$StepOSWidget_release();
    }

    public final void setContactName(String str) {
        this.contactName = str;
        updateText();
    }

    public final void setDragState(boolean dragged) {
        this.dragged = dragged;
        setAlpha(dragged ? 0.35f : 1.0f);
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int resId) throws Resources.NotFoundException {
        super.setTextAppearance(resId);
        applyChipMetrics();
    }

    public final void updateText() {
        String str = this.contactName;
        setText((str == null || str.length() == 0) ? this.address : this.contactName);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSRecipientChip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final void applyColors(int textColor, int pillColor, boolean selected, boolean drawBackground) throws Resources.NotFoundException {
        Drawable drawableE;
        Drawable drawableMutate;
        this.drawBackground = drawBackground;
        setTextColor(textColor);
        setSelected(selected);
        Drawable drawable = null;
        if (drawBackground && (drawableE = androidx.core.content.a.e(getContext(), R.drawable.stepos_bg_recipient_chip_selected)) != null && (drawableMutate = drawableE.mutate()) != null) {
            drawableMutate.setTint(pillColor);
            drawable = drawableMutate;
        }
        setBackground(drawable);
        applyChipMetrics();
    }

    public /* synthetic */ StepOSRecipientChip(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? android.R.attr.textViewStyle : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSRecipientChip(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.address = "";
        setIncludeFontPadding(false);
        setGravity(17);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setClickable(true);
        setLongClickable(true);
        applyChipMetrics();
    }
}
