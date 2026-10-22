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
@ProtoMessage("webcast.api.battle.UserListArea")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R#\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IUserListAreaFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/z9;", "", "name$delegate", "Ljava/lang/Object;", "getName", "()Ljava/lang/String;", "name", "emptyTxt$delegate", "getEmptyTxt", "emptyTxt", "", "Lcom/bytedance/android/livesdk/link/model/IUserFlexImpl;", "users$delegate", "getUsers", "()Ljava/util/List;", "users", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IUserListAreaFlexImpl extends FlexModelBase<z9> implements z9, vh7.h {

    @SerializedName("empty_text")
    protected String _$$emptyTxt;

    @SerializedName("name")
    protected String _$$name;

    @SerializedName("user_infos")
    protected List<IUserFlexImpl> _$$users;

    public IUserListAreaFlexImpl() {
        super(z9.class);
    }

    public IUserListAreaFlexImpl(am3.g r100) {
        super(z9.class);
        this._$$users = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$name = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$emptyTxt = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$users.add(new IUserFlexImpl(r100));
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.z9
    public final String getEmptyTxt() {
        return this._$$emptyTxt;
    }

    @Override // com.bytedance.android.livesdk.link.model.z9
    public final String getName() {
        return this._$$name;
    }

    @Override // com.bytedance.android.livesdk.link.model.z9
    public final List<IUserFlexImpl> getUsers() {
        return this._$$users;
    }
}
