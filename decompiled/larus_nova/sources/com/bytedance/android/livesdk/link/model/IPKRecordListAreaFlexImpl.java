package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.api.battle.PKRecordListArea")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPKRecordListAreaFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/l7;", "", "name$delegate", "Ljava/lang/Object;", "getName", "()Ljava/lang/String;", "name", "", "Lcom/bytedance/android/livesdk/link/model/IPKRecordFlexImpl;", "records$delegate", "getRecords", "()Ljava/util/List;", "records", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPKRecordListAreaFlexImpl extends FlexModelBase<l7> implements l7, vh7.h {

    @SerializedName("name")
    protected String _$$name;

    @SerializedName("record_list")
    protected List<IPKRecordFlexImpl> _$$records;

    public IPKRecordListAreaFlexImpl() {
        super(l7.class);
    }

    public IPKRecordListAreaFlexImpl(am3.g r100) {
        super(l7.class);
        this._$$records = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$name = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$records.add(new IPKRecordFlexImpl(r100));
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.l7
    public final String getName() {
        return this._$$name;
    }

    @Override // com.bytedance.android.livesdk.link.model.l7
    public final List<IPKRecordFlexImpl> getRecords() {
        return this._$$records;
    }
}
