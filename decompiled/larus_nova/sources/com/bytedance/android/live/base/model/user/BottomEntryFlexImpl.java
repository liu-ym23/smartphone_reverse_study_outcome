package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.User.BottomEntry")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b)\u0010*R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R+\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR+\u0010$\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u001e8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R+\u0010(\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0006\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001c¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/base/model/user/BottomEntryFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/user/e;", "", "<set-?>", "status$delegate", "Ljava/lang/Object;", "getStatus", "()I", "setStatus", "(I)V", "status", "", "icon$delegate", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "icon", "schema$delegate", "getSchema", "setSchema", "schema", "", "mysteryMan$delegate", "getMysteryMan", "()Z", "setMysteryMan", "(Z)V", "mysteryMan", "", "gradeLevel$delegate", "getGradeLevel", "()J", "setGradeLevel", "(J)V", "gradeLevel", "hideGradeLevel$delegate", "getHideGradeLevel", "setHideGradeLevel", "hideGradeLevel", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BottomEntryFlexImpl extends FlexModelBase<e> implements e, vh7.h {

    @SerializedName("grade_level")
    protected long _$$gradeLevel;

    @SerializedName("hide_grade_level")
    protected boolean _$$hideGradeLevel;

    @SerializedName("icon")
    protected String _$$icon;

    @SerializedName("mystery_man")
    protected boolean _$$mysteryMan;

    @SerializedName("schema")
    protected String _$$schema;

    @SerializedName("status")
    protected int _$$status;

    public BottomEntryFlexImpl() {
        super(e.class);
        this._$$icon = "";
        this._$$schema = "";
        this._$$mysteryMan = false;
        this._$$hideGradeLevel = false;
    }

    @Override // com.bytedance.android.live.base.model.user.e
    public final long getGradeLevel() {
        return this._$$gradeLevel;
    }

    @Override // com.bytedance.android.live.base.model.user.e
    public final boolean getHideGradeLevel() {
        return this._$$hideGradeLevel;
    }

    @Override // com.bytedance.android.live.base.model.user.e
    public final String getIcon() {
        return this._$$icon;
    }

    @Override // com.bytedance.android.live.base.model.user.e
    public final boolean getMysteryMan() {
        return this._$$mysteryMan;
    }

    @Override // com.bytedance.android.live.base.model.user.e
    public final String getSchema() {
        return this._$$schema;
    }

    @Override // com.bytedance.android.live.base.model.user.e
    public final int getStatus() {
        return this._$$status;
    }

    public BottomEntryFlexImpl(am3.g r100) {
        super(e.class);
        setThreadSafe(false);
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L24;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this._$$status = r100.i();
        r102 = r102 | 1;
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this._$$icon = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        this._$$schema = am3.h.c(r100);
        goto L3
    L12:
        if (r103 != 4) goto L14;
        this._$$mysteryMan = am3.h.a(r100);
        r102 = r102 | 2;
        goto L3
    L14:
        if (r103 != 6) goto L16;
        this._$$gradeLevel = r100.j();
        r102 = r102 | 4;
        goto L3
    L16:
        if (r103 != 7) goto L17;
        this._$$hideGradeLevel = am3.h.a(r100);
        r102 = r102 | 8;
        goto L3
    L17:
        am3.h.d(r104, r100);
        goto L3
    L24:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$icon != null) goto L28;
        this._$$icon = "";
    L28:
        if (this._$$schema != null) goto L31;
        this._$$schema = "";
    L31:
        if ((r102 & 2) != 0) goto L34;
        this._$$mysteryMan = false;
    L34:
        if ((r102 & 8) != 0) goto L58;
        this._$$hideGradeLevel = false;
        return;
    }

    @Override // com.bytedance.android.live.base.model.user.e
    public final void setGradeLevel(long r100) {
        this._$$gradeLevel = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.e
    public final void setHideGradeLevel(boolean r100) {
        this._$$hideGradeLevel = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.e
    public final void setIcon(String r100) {
        this._$$icon = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.e
    public final void setMysteryMan(boolean r100) {
        this._$$mysteryMan = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.e
    public final void setSchema(String r100) {
        this._$$schema = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.e
    public final void setStatus(int r100) {
        this._$$status = r100;
    }
}
