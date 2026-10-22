package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R.\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R.\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R.\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ClientComponent;", "", "()V", "isOpen", "", "()Ljava/lang/Boolean;", "setOpen", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "landscapeComponentMap", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/ClientComponentInfo;", "getLandscapeComponentMap", "()Ljava/util/Map;", "setLandscapeComponentMap", "(Ljava/util/Map;)V", "portraitComponentMap", "getPortraitComponentMap", "setPortraitComponentMap", "previewDefaultComponentMap", "getPreviewDefaultComponentMap", "setPreviewDefaultComponentMap", GXTemplateKey.GAIAX_TEMPLATE_ID, "", "getTemplateId", "()Ljava/lang/Integer;", "setTemplateId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ClientComponent implements h {

    @SerializedName("is_open")
    protected Boolean isOpen;

    @SerializedName("landscape_component_map")
    protected Map<String, ClientComponentInfo> landscapeComponentMap;

    @SerializedName("portrait_component_map")
    protected Map<String, ClientComponentInfo> portraitComponentMap;

    @SerializedName("preview_default_component_map")
    protected Map<String, ClientComponentInfo> previewDefaultComponentMap;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID)
    protected Integer templateId;

    public ClientComponent() {
        this.isOpen = Boolean.FALSE;
    }

    public final Map<String, ClientComponentInfo> getLandscapeComponentMap() {
        return this.landscapeComponentMap;
    }

    public final Map<String, ClientComponentInfo> getPortraitComponentMap() {
        return this.portraitComponentMap;
    }

    public final Map<String, ClientComponentInfo> getPreviewDefaultComponentMap() {
        return this.previewDefaultComponentMap;
    }

    public final Integer getTemplateId() {
        return this.templateId;
    }

    public final Boolean isOpen() {
        return this.isOpen;
    }

    public ClientComponent(g r110) {
        this.portraitComponentMap = new HashMap();
        this.landscapeComponentMap = new HashMap();
        this.previewDefaultComponentMap = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L65;
        String r102 = null;
        if (r101 == 1) goto L49;
        if (r101 == 2) goto L33;
        if (r101 != 3) goto L11;
        this.isOpen = Boolean.valueOf(am3.h.a(r110));
        goto L3
    L11:
        if (r101 != 4) goto L13;
        this.templateId = Integer.valueOf((int) r110.j());
        goto L3
    L13:
        if (r101 != 5) goto L14;
        long r103 = r110.c();
        ClientComponentInfo r104 = null;
    L16:
        int r111 = r110.f();
        if (r111 == (-1)) goto L23;
        if (r111 != 1) goto L19;
        r102 = am3.h.c(r110);
        goto L16
    L19:
        if (r111 != 2) goto L20;
        r104 = new ClientComponentInfo(r110);
        goto L16
    L20:
        am3.h.e(r110);
        goto L16
    L23:
        r110.d(r103);
        Map<String, ClientComponentInfo> r105 = this.previewDefaultComponentMap;
        if (r102 == null) goto L30;
        if (r104 == null) goto L28;
    L60:
        r105.put(r102, r104);
        goto L3
    L28:
        throw new IllegalStateException("Value must not be null");
    L30:
        throw new IllegalStateException("Key must not be null");
    L14:
        am3.h.e(r110);
        goto L3
    L33:
        long r106 = r110.c();
        r104 = null;
    L34:
        int r112 = r110.f();
        if (r112 == (-1)) goto L41;
        if (r112 != 1) goto L37;
        r102 = am3.h.c(r110);
        goto L34
    L37:
        if (r112 != 2) goto L38;
        r104 = new ClientComponentInfo(r110);
        goto L34
    L38:
        am3.h.e(r110);
        goto L34
    L41:
        r110.d(r106);
        r105 = this.landscapeComponentMap;
        if (r102 == null) goto L48;
        if (r104 != null) goto L60;
        throw new IllegalStateException("Value must not be null");
    L48:
        throw new IllegalStateException("Key must not be null");
    L49:
        long r107 = r110.c();
        r104 = null;
    L50:
        int r113 = r110.f();
        if (r113 == (-1)) goto L57;
        if (r113 != 1) goto L53;
        r102 = am3.h.c(r110);
        goto L50
    L53:
        if (r113 != 2) goto L54;
        r104 = new ClientComponentInfo(r110);
        goto L50
    L54:
        am3.h.e(r110);
        goto L50
    L57:
        r110.d(r107);
        r105 = this.portraitComponentMap;
        if (r102 == null) goto L64;
        if (r104 != null) goto L60;
        throw new IllegalStateException("Value must not be null");
    L64:
        throw new IllegalStateException("Key must not be null");
    L65:
        r110.d(r100);
        if (this.isOpen != null) goto L116;
        this.isOpen = Boolean.FALSE;
        return;
    }

    public final void setLandscapeComponentMap(Map<String, ClientComponentInfo> r100) {
        this.landscapeComponentMap = r100;
    }

    public final void setOpen(Boolean r100) {
        this.isOpen = r100;
    }

    public final void setPortraitComponentMap(Map<String, ClientComponentInfo> r100) {
        this.portraitComponentMap = r100;
    }

    public final void setPreviewDefaultComponentMap(Map<String, ClientComponentInfo> r100) {
        this.previewDefaultComponentMap = r100;
    }

    public final void setTemplateId(Integer r100) {
        this.templateId = r100;
    }
}
