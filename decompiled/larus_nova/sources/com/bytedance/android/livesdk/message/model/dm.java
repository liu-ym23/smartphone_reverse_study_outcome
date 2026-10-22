package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ToolBarControlMessage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0003B\u0007¢\u0006\u0004\ba\u0010\u001dJ-\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00030\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ/\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00030\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\n\u0010\tJ\b\u0010\f\u001a\u00020\u000bH\u0016R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0019\u0010\u0014\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R(\u0010\u001e\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u001e\u0010\u0014\u0012\u0004\b!\u0010\u001d\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R$\u0010\"\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010#\u001a\u0004\b0\u0010%\"\u0004\b1\u0010'R$\u00102\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010#\u001a\u0004\b3\u0010%\"\u0004\b4\u0010'R\"\u00105\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0014\u001a\u0004\b6\u0010\u0016\"\u0004\b7\u0010\u0018R(\u00108\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b8\u0010\u0014\u0012\u0004\b;\u0010\u001d\u001a\u0004\b9\u0010\u0016\"\u0004\b:\u0010\u0018R*\u0010>\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR*\u0010D\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010?\u001a\u0004\bE\u0010A\"\u0004\bF\u0010CR\u0014\u0010H\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0016R\u0014\u0010J\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u0016R\u0014\u0010L\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u0016R\u0016\u0010N\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010%R\u0016\u0010R\u001a\u0004\u0018\u00010O8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0016\u0010T\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010%R\u0016\u0010V\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u0010%R\u0014\u0010X\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010\u0016R\u0014\u0010\\\u001a\u00020Y8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u001a\u0010^\u001a\b\u0012\u0004\u0012\u00020=0<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b]\u0010AR\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020=0<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b_\u0010A¨\u0006b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/dm;", "Llm2/a;", "Lvh7/c$a;", "Lcom/bytedance/android/live/base/model/message/l5;", "Lvh7/e;", "R", "Ljava/lang/Class;", "aClass", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getMsgLogId", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "delegate", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "getDelegate", "()Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "", "_componentType", "I", "get_componentType", "()I", "set_componentType", "(I)V", "_eventType", "get_eventType", "set_eventType", "get_eventType$annotations", "()V", "_opType", "get_opType", "set_opType", "get_opType$annotations", "_text", "Ljava/lang/String;", "get_text", "()Ljava/lang/String;", "set_text", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "_icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_icon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_icon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "_schema", "get_schema", "set_schema", "_extraData", "get_extraData", "set_extraData", "_groupId", "get_groupId", "set_groupId", "_showType", "get_showType", "set_showType", "get_showType$annotations", "", "Lcom/bytedance/android/live/base/model/message/k5;", "_lowList", "Ljava/util/List;", "get_lowList", "()Ljava/util/List;", "set_lowList", "(Ljava/util/List;)V", "_highList", "get_highList", "set_highList", "getComponentType", "componentType", "getEventType", "eventType", "getOpType", "opType", "getText", "text", "Lpy/k;", "getIcon", "()Lpy/k;", "icon", "getSchema", "schema", "getExtraData", ControlRule.KEY_EXTRA_DATA, "getGroupId", "groupId", "", "getShowType", "()J", "showType", "getLowList", "lowList", "getHighList", "highList", "<init>", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class dm extends lm2.a implements vh7.c.a<com.bytedance.android.live.base.model.message.l5>, com.bytedance.android.live.base.model.message.l5, vh7.h {

    @SerializedName("component_type")
    protected int _componentType;

    @SerializedName("event_type")
    protected int _eventType;

    @SerializedName("extra")
    protected String _extraData;

    @SerializedName("group_id")
    protected int _groupId;

    @SerializedName("high_priority_exclusion_list")
    protected List<? extends com.bytedance.android.live.base.model.message.k5> _highList;

    @SerializedName("icon")
    protected ImageModel _icon;

    @SerializedName("low_priority_exclusion_list")
    protected List<? extends com.bytedance.android.live.base.model.message.k5> _lowList;

    @SerializedName("op_type")
    protected int _opType;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
    protected String _schema;

    @SerializedName("show_type")
    protected int _showType;

    @SerializedName("text")
    protected String _text;
    private final transient FlexModelDelegate<com.bytedance.android.live.base.model.message.l5> delegate;

    public static /* synthetic */ void get_eventType$annotations() {
    }

    public static /* synthetic */ void get_opType$annotations() {
    }

    public static /* synthetic */ void get_showType$annotations() {
    }

    @Override // com.bytedance.android.live.base.model.message.l5
    public long getShowType() {
        return this._showType;
    }

    public dm() {
        this.delegate = new FlexModelDelegate(com.bytedance.android.live.base.model.message.l5.class, this);
        this.type = MessageType.TOOLBAR_CONTROL_MESSAGE;
    }

    @Override // com.bytedance.android.live.base.model.message.l5
    public String getMsgLogId() {
        CommonMessageData r100 = getBaseMessage();
        if (r100 == null) goto L6;
        String r101 = r100.getLogId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.base.model.message.l5
    public int getComponentType() {
        return this._componentType;
    }

    @Override // vh7.c.a
    public FlexModelDelegate<com.bytedance.android.live.base.model.message.l5> getDelegate() {
        return this.delegate;
    }

    @Override // com.bytedance.android.live.base.model.message.l5
    public int getEventType() {
        return this._eventType;
    }

    @Override // com.bytedance.android.live.base.model.message.l5
    public String getExtraData() {
        return this._extraData;
    }

    @Override // com.bytedance.android.live.base.model.message.l5
    public int getGroupId() {
        return this._groupId;
    }

    @Override // com.bytedance.android.live.base.model.message.l5
    public List<com.bytedance.android.live.base.model.message.k5> getHighList() {
        return this._highList;
    }

    @Override // com.bytedance.android.live.base.model.message.l5
    public py.k getIcon() {
        return this._icon;
    }

    @Override // com.bytedance.android.live.base.model.message.l5
    public List<com.bytedance.android.live.base.model.message.k5> getLowList() {
        return this._lowList;
    }

    @Override // com.bytedance.android.live.base.model.message.l5
    public int getOpType() {
        return this._opType;
    }

    @Override // com.bytedance.android.live.base.model.message.l5
    public String getSchema() {
        return this._schema;
    }

    @Override // com.bytedance.android.live.base.model.message.l5
    public String getText() {
        return this._text;
    }

    public final int get_componentType() {
        return this._componentType;
    }

    public final int get_eventType() {
        return this._eventType;
    }

    public final String get_extraData() {
        return this._extraData;
    }

    public final int get_groupId() {
        return this._groupId;
    }

    public final List<com.bytedance.android.live.base.model.message.k5> get_highList() {
        return this._highList;
    }

    public final ImageModel get_icon() {
        return this._icon;
    }

    public final List<com.bytedance.android.live.base.model.message.k5> get_lowList() {
        return this._lowList;
    }

    public final int get_opType() {
        return this._opType;
    }

    public final String get_schema() {
        return this._schema;
    }

    public final int get_showType() {
        return this._showType;
    }

    public final String get_text() {
        return this._text;
    }

    public dm(am3.g r100) {
        this._lowList = new ArrayList();
        this._highList = new ArrayList();
        this.delegate = new FlexModelDelegate(com.bytedance.android.live.base.model.message.l5.class, this);
        getDelegate().setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L22;
        am3.g.a r103 = getDelegate().decodeExtensionFields(r102, r100);
        if (r102 != 99) goto L7;
        this._extraData = am3.h.c(r100);
        goto L3
    L7:
        switch(r102) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L10;
            case 11: goto L9;
            default: goto L8;
        };
    L9:
        List<? extends com.bytedance.android.live.base.model.message.k5> r104 = this._lowList;
    L11:
        r104.add(vh7.f.a(r100, com.bytedance.android.live.base.model.message.k5.class));
        goto L3
    L10:
        r104 = this._highList;
        goto L11
    L12:
        this._showType = (int) r100.j();
        goto L3
    L13:
        this._icon = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L14:
        this._schema = am3.h.c(r100);
        goto L3
    L15:
        this._text = am3.h.c(r100);
        goto L3
    L16:
        this._opType = r100.i();
        goto L3
    L17:
        this._componentType = r100.i();
        goto L3
    L18:
        this._groupId = r100.i();
        goto L3
    L19:
        this._eventType = r100.i();
        goto L3
    L20:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        am3.h.d(r103, r100);
        goto L3
    L22:
        r100.d(r101);
        getDelegate().setThreadSafe(true);
        this.type = MessageType.TOOLBAR_CONTROL_MESSAGE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<com.bytedance.android.live.base.model.message.l5>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "aClass");
        return (R) getDelegate().castTo(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<com.bytedance.android.live.base.model.message.l5>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "aClass");
        return (R) getDelegate().castToOrNull(r100);
    }

    public final void set_componentType(int r100) {
        this._componentType = r100;
    }

    public final void set_eventType(int r100) {
        this._eventType = r100;
    }

    public final void set_extraData(String r100) {
        this._extraData = r100;
    }

    public final void set_groupId(int r100) {
        this._groupId = r100;
    }

    public final void set_highList(List<? extends com.bytedance.android.live.base.model.message.k5> r100) {
        this._highList = r100;
    }

    public final void set_icon(ImageModel r100) {
        this._icon = r100;
    }

    public final void set_lowList(List<? extends com.bytedance.android.live.base.model.message.k5> r100) {
        this._lowList = r100;
    }

    public final void set_opType(int r100) {
        this._opType = r100;
    }

    public final void set_schema(String r100) {
        this._schema = r100;
    }

    public final void set_showType(int r100) {
        this._showType = r100;
    }

    public final void set_text(String r100) {
        this._text = r100;
    }
}
