package com.obric.oui.radio;

import android.view.View;
import com.android.contacts.calllog.v2.CallLogListAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ORadio.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0016\u001a\u00020\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/radio/ORadioGroupHelper;", "", "radios", "", "Lcom/obric/oui/radio/ORadio;", "([Lcom/obric/oui/radio/ORadio;)V", "onSelectChangeListener", "Lcom/obric/oui/radio/ORadioGroupHelper$OnSelectChangeListener;", "getOnSelectChangeListener", "()Lcom/obric/oui/radio/ORadioGroupHelper$OnSelectChangeListener;", "setOnSelectChangeListener", "(Lcom/obric/oui/radio/ORadioGroupHelper$OnSelectChangeListener;)V", "radioGroupOnClickListener", "Landroid/view/View$OnClickListener;", "radioSet", "", "value", CallLogListAdapter.PAYLOAD_SELECTION, "getSelection", "()Lcom/obric/oui/radio/ORadio;", "setSelection", "(Lcom/obric/oui/radio/ORadio;)V", "unSelectAll", "", "OnSelectChangeListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ORadioGroupHelper {
    private OnSelectChangeListener onSelectChangeListener;
    private final View.OnClickListener radioGroupOnClickListener;
    private final Set<ORadio> radioSet;
    private ORadio selection;

    /* JADX INFO: compiled from: ORadio.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/radio/ORadioGroupHelper$OnSelectChangeListener;", "", "onSelectChange", "", CallLogListAdapter.PAYLOAD_SELECTION, "Lcom/obric/oui/radio/ORadio;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnSelectChangeListener {
        void onSelectChange(ORadio r1);
    }

    public static /* synthetic */ void $r8$lambda$HfBiyCE0f3eHoVJKiIl7BcBUuUY(ORadioGroupHelper r0, View r1) {
        m650radioGroupOnClickListener$lambda2(r0, r1);
    }

    public ORadioGroupHelper(ORadio... r5) {
        Intrinsics.checkNotNullParameter(r5, "radios");
        LinkedHashSet r0 = new LinkedHashSet();
        this.radioSet = r0;
        this.radioGroupOnClickListener = new ORadioGroupHelper$$ExternalSyntheticLambda0(this);
        CollectionsKt.addAll(r0, r5);
        ArrayList r6 = new ArrayList();
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r2 = r1.next();
        if (((ORadio) r2).isChecked() == false) goto L4;
        r6.add(r2);
        goto L4
    L8:
        Iterator r7 = r6.iterator();
        int r3 = 0;
    L10:
        if (r7.hasNext() == false) goto L19;
        Object r4 = r7.next();
        int r8 = r3 + 1;
        if (r3 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        ORadio r9 = (ORadio) r4;
        if (r3 != 0) goto L17;
        boolean r10 = true;
    L18:
        r9.setChecked(r10);
        r3 = r8;
        goto L10
    L17:
        r10 = false;
        goto L18
    L19:
        Iterator<T> r11 = this.radioSet.iterator();
    L21:
        if (r11.hasNext() == false) goto L23;
        ((ORadio) r11.next()).setOnClickListener(this.radioGroupOnClickListener);
        goto L21
    }

    public final OnSelectChangeListener getOnSelectChangeListener() {
        return this.onSelectChangeListener;
    }

    public final void setOnSelectChangeListener(OnSelectChangeListener r1) {
        this.onSelectChangeListener = r1;
    }

    public final ORadio getSelection() {
        return this.selection;
    }

    private final void setSelection(ORadio r2) {
        if (Intrinsics.areEqual(this.selection, r2) == false) goto L5;
        return;
    L5:
        OnSelectChangeListener r0 = this.onSelectChangeListener;
        if (r0 == null) goto L9;
        r0.onSelectChange(r2);
    L9:
        this.selection = r2;
    }

    /* JADX INFO: renamed from: radioGroupOnClickListener$lambda-2, reason: not valid java name */
    private static final void m650radioGroupOnClickListener$lambda2(ORadioGroupHelper r6, View r7) {
        Intrinsics.checkNotNullParameter(r6, "this$0");
        Iterator<T> r0 = r6.radioSet.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Object r1 = r0.next();
        ORadio r4 = (ORadio) r1;
        if (r4.isEnabled() == false) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == false) goto L4;
    L14:
        if (r1 == null) goto L16;
        return;
    L16:
        Iterator<T> r2 = r6.radioSet.iterator();
    L18:
        if (r2.hasNext() == false) goto L20;
        ((ORadio) r2.next()).setChecked(false);
        goto L18
    L20:
        if (r7 == null) goto L24;
        ORadio r8 = (ORadio) r7;
        r8.setChecked(true);
        r6.setSelection(r8);
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.radio.ORadio");
    L8:
        if (r4.isChecked() == false) goto L10;
        r5 = true;
        goto L11
    L13:
        r1 = null;
        goto L14
    }

    public final void unSelectAll() {
        Iterator<T> r2 = this.radioSet.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        ORadio r0 = (ORadio) r2.next();
        if (r0.isEnabled() == false) goto L4;
        r0.setChecked(true);
        goto L4
    }
}
