package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.AIPublicScreenContainer.Ability")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR,\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u00020\u00178\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/Ability;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IAbility;", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "params", "", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "schema", "getSchema", "setSchema", "text", "getText", "setText", "type", "", "getType", "()J", "setType", "(J)V", "toString", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class Ability extends FlexModelBase<IAbility> implements IAbility, h {
    public static final Companion Companion = null;
    public static final long TYPE_REQUEST = 2;
    public static final long TYPE_SCHEMA = 1;

    @SerializedName("name")
    protected String name;

    @SerializedName("params")
    protected Map<String, String> params;

    @SerializedName("schema")
    protected String schema;

    @SerializedName("text")
    protected String text;

    @SerializedName("type")
    protected long type;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/Ability$Companion;", "", "()V", "TYPE_REQUEST", "", "TYPE_SCHEMA", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Ability() {
        super(IAbility.class);
    }

    public String toString() {
        return "Ability{type=" + getType() + ", text='" + getText() + "', schema='" + getSchema() + "', name='" + getName() + "', params=" + getParams() + '}';
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAbility
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAbility
    public Map<String, String> getParams() {
        return this.params;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAbility
    public String getSchema() {
        return this.schema;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAbility
    public String getText() {
        return this.text;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAbility
    public long getType() {
        return this.type;
    }

    public Ability(g r110) {
        super(IAbility.class);
        this.params = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L36;
        g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 1) goto L8;
        this.type = r110.j();
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.text = am3.h.c(r110);
        goto L3
    L10:
        if (r101 != 3) goto L12;
        this.schema = am3.h.c(r110);
        goto L3
    L12:
        if (r101 != 4) goto L14;
        this.name = am3.h.c(r110);
        goto L3
    L14:
        if (r101 != 5) goto L15;
        long r103 = r110.c();
        String r104 = null;
        String r105 = null;
    L17:
        int r106 = r110.f();
        if (r106 == (-1)) goto L24;
        if (r106 != 1) goto L20;
        r104 = am3.h.c(r110);
        goto L17
    L20:
        if (r106 != 2) goto L21;
        r105 = am3.h.c(r110);
        goto L17
    L21:
        am3.h.e(r110);
        goto L17
    L24:
        r110.d(r103);
        Map<String, String> r107 = this.params;
        if (r104 == null) goto L31;
        if (r105 == null) goto L29;
        r107.put(r104, r105);
        goto L3
    L29:
        throw new IllegalStateException("Value must not be null");
    L31:
        throw new IllegalStateException("Key must not be null");
    L15:
        am3.h.d(r102, r110);
        goto L3
    L36:
        r110.d(r100);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAbility
    public void setName(String r100) {
        this.name = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAbility
    public void setParams(Map<String, String> r100) {
        this.params = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAbility
    public void setSchema(String r100) {
        this.schema = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAbility
    public void setText(String r100) {
        this.text = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAbility
    public void setType(long r100) {
        this.type = r100;
    }
}
