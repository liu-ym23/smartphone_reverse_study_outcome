package com.android.contacts.calllog.blocked;

import com.android.contacts.calllog.blocked.data.BlockedCallEntity;
import com.obric.utils.ObricGroupCallRecyclerViewAdapter;
import kotlin.Metadata;

/* JADX INFO: compiled from: BlockedCallAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/android/contacts/calllog/blocked/IOnDataChangeListener;", "", "onItemClickChecked", "", "position", "", "data", "Lcom/obric/utils/ObricGroupCallRecyclerViewAdapter$GroupCallData;", "Lcom/android/contacts/calllog/blocked/data/BlockedCallEntity;", "isChecked", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IOnDataChangeListener {
    void onItemClickChecked(int r1, ObricGroupCallRecyclerViewAdapter.GroupCallData<BlockedCallEntity> r2, boolean r3);
}
