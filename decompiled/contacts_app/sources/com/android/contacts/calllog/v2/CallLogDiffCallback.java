package com.android.contacts.calllog.v2;

import com.obric.oui.orecyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallLogDiffCallback.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogDiffCallback;", "Lcom/obric/oui/orecyclerview/widget/DiffUtil$ItemCallback;", "Lcom/android/contacts/calllog/v2/CallLogItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "getChangePayload", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogDiffCallback extends DiffUtil.ItemCallback<CallLogItem> {
    public CallLogDiffCallback() {
    }

    @Override // com.obric.oui.orecyclerview.widget.DiffUtil.ItemCallback
    public /* bridge */ /* synthetic */ boolean areContentsTheSame(CallLogItem r1, CallLogItem r2) {
        return areContentsTheSame2(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.DiffUtil.ItemCallback
    public /* bridge */ /* synthetic */ boolean areItemsTheSame(CallLogItem r1, CallLogItem r2) {
        return areItemsTheSame2(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.DiffUtil.ItemCallback
    public /* bridge */ /* synthetic */ Object getChangePayload(CallLogItem r1, CallLogItem r2) {
        return getChangePayload2(r1, r2);
    }

    /* JADX INFO: renamed from: areItemsTheSame, reason: avoid collision after fix types in other method */
    public boolean areItemsTheSame2(CallLogItem r3, CallLogItem r4) {
        Intrinsics.checkNotNullParameter(r3, "oldItem");
        Intrinsics.checkNotNullParameter(r4, "newItem");
        if (r3.getId() != r4.getId()) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getChangePayload, reason: avoid collision after fix types in other method */
    public Object getChangePayload2(CallLogItem r5, CallLogItem r6) {
        Intrinsics.checkNotNullParameter(r5, "oldItem");
        Intrinsics.checkNotNullParameter(r6, "newItem");
        if (Intrinsics.areEqual(r5.getNumber(), r6.getNumber()) == true) goto L5;
    L35:
        boolean r4 = false;
    L36:
        if (r4 == false) goto L38;
        return CallLogListAdapter.PAYLOAD_ITEM_META;
    L38:
        return null;
    L5:
        if (r5.getCallType() != r6.getCallType()) goto L35;
        if (r5.getDate() != r6.getDate()) goto L35;
        if (r5.getDuration() != r6.getDuration()) goto L35;
        if (r5.getSimSlot() != r6.getSimSlot()) goto L35;
        if (r5.getGroupSize() != r6.getGroupSize()) goto L35;
        if (Intrinsics.areEqual(r5.getChildIds(), r6.getChildIds()) == false) goto L35;
        if (Intrinsics.areEqual(r5.getCachedLookupUri(), r6.getCachedLookupUri()) == false) goto L35;
        if (r5.getPresentation() != r6.getPresentation()) goto L35;
        if (r5.getHasRecording() != r6.getHasRecording()) goto L35;
        if (r5.getShowSimIcon() != r6.getShowSimIcon()) goto L35;
        if (r5.getFeatures() != r6.getFeatures()) goto L35;
        if (Intrinsics.areEqual(r5.getVoicemailUri(), r6.getVoicemailUri()) == false) goto L35;
        if (Intrinsics.areEqual(r5.getLocation(), r6.getLocation()) == false) goto L35;
        if (r5.isMarked() == r6.isMarked()) goto L33;
    L34:
        r4 = true;
        goto L36
    L33:
        if (r5.isBlocked() == r6.isBlocked()) goto L35;
        goto L34
    }

    /* JADX INFO: renamed from: areContentsTheSame, reason: avoid collision after fix types in other method */
    public boolean areContentsTheSame2(CallLogItem r5, CallLogItem r6) {
        Intrinsics.checkNotNullParameter(r5, "oldItem");
        Intrinsics.checkNotNullParameter(r6, "newItem");
        if (r5.getId() == r6.getId()) goto L5;
    L37:
        return false;
    L5:
        if (Intrinsics.areEqual(r5.getNumber(), r6.getNumber()) == false) goto L37;
        if (r5.getCallType() != r6.getCallType()) goto L37;
        if (r5.getDate() != r6.getDate()) goto L37;
        if (r5.getDuration() != r6.getDuration()) goto L37;
        if (r5.getSimSlot() != r6.getSimSlot()) goto L37;
        if (r5.getGroupSize() != r6.getGroupSize()) goto L37;
        if (Intrinsics.areEqual(r5.getChildIds(), r6.getChildIds()) == false) goto L37;
        if (Intrinsics.areEqual(r5.getCachedLookupUri(), r6.getCachedLookupUri()) == false) goto L37;
        if (r5.getPresentation() != r6.getPresentation()) goto L37;
        if (r5.getHasRecording() != r6.getHasRecording()) goto L37;
        if (r5.isMarked() != r6.isMarked()) goto L37;
        if (r5.getShowSimIcon() != r6.getShowSimIcon()) goto L37;
        if (r5.isBlocked() != r6.isBlocked()) goto L37;
        if (r5.getFeatures() != r6.getFeatures()) goto L37;
        if (Intrinsics.areEqual(r5.getVoicemailUri(), r6.getVoicemailUri()) == false) goto L37;
        if (Intrinsics.areEqual(r5.getLocation(), r6.getLocation()) == false) goto L37;
        return true;
    }
}
