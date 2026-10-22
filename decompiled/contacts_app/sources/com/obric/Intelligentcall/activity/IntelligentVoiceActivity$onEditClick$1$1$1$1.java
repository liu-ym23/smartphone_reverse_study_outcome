package com.obric.Intelligentcall.activity;

import com.GlobalProxyLancet;
import com.obric.network.request.intelligentvoice.SoundCopyResponseBody;
import com.obric.network.request.intelligentvoice.SoundListGetResponseDetail;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: IntelligentVoiceActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/network/request/intelligentvoice/SoundCopyResponseBody;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class IntelligentVoiceActivity$onEditClick$1$1$1$1 extends Lambda implements Function1<SoundCopyResponseBody, Unit> {
    final /* synthetic */ SoundListGetResponseDetail $data;
    final /* synthetic */ int $index;
    final /* synthetic */ int $position;
    final /* synthetic */ String $text;
    final /* synthetic */ IntelligentVoiceActivity this$0;

    /* JADX INFO: renamed from: $r8$lambda$nRyiFVy7Q6HpQaNAhap-eMsZW2w, reason: not valid java name */
    public static /* synthetic */ void m307$r8$lambda$nRyiFVy7Q6HpQaNAhapeMsZW2w(SoundListGetResponseDetail r0, String r1, SoundCopyResponseBody r2, IntelligentVoiceActivity r3, int r4, int r5) {
        invoke$lambda$0(r0, r1, r2, r3, r4, r5);
    }

    IntelligentVoiceActivity$onEditClick$1$1$1$1(IntelligentVoiceActivity r1, SoundListGetResponseDetail r2, String r3, int r4, int r5) {
        this.this$0 = r1;
        this.$data = r2;
        this.$text = r3;
        this.$index = r4;
        this.$position = r5;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SoundCopyResponseBody r1) {
        invoke2(r1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final SoundCopyResponseBody r9) {
        final IntelligentVoiceActivity r7 = this.this$0;
        final SoundListGetResponseDetail r1 = this.$data;
        final String r2 = this.$text;
        final int r5 = this.$index;
        final int r6 = this.$position;
        r7.runOnUiThread(new IntelligentVoiceActivity$onEditClick$1$1$1$1$$ExternalSyntheticLambda0(r1, r2, r9, r7, r5, r6));
    }

    private static final void invoke$lambda$0(SoundListGetResponseDetail r6, String r7, SoundCopyResponseBody r8, IntelligentVoiceActivity r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r6, "$data");
        Intrinsics.checkNotNullParameter(r7, "$text");
        Intrinsics.checkNotNullParameter(r9, "this$0");
        StringBuilder r0 = new StringBuilder("renameSound success hasSpeakerId=");
        String r12 = r6.getSpeakerId();
        if (r12 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i("IntelligentVoiceActivity", r0.append(!r13).append(", newName=").append(r7).append(", response=").append(r8).toString());
        IntelligentVoiceActivity.access$hideLoading(r9);
        r9.getCustomSoundList().set(r10, new SoundListGetResponseDetail(r9.getCustomSoundList().get(r10).getSpeakerId(), r7, null, null, null));
        IntelligentVoiceActivity.access$updateSoundList(r9, r11);
        return;
    L5:
        if (r12.length() == 0) goto L8;
        r13 = false;
        goto L9
    }
}
