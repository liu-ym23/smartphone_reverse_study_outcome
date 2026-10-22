package com.bytedance.android.livesdk.interactivity.comment.share.model;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0006\fB\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/share/model/a;", "", "", "Lcom/bytedance/android/livesdk/interactivity/comment/share/model/a$b;", "shareDataList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setShareDataList", "(Ljava/util/List;)V", "<init>", "()V", "b", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("share_data_list")
    protected List<b> shareDataList;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.share.model.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b3\u00104R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R0\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR$\u00100\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\b¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/share/model/a$a;", "", "", "itemId", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "setItemId", "(Ljava/lang/String;)V", "Lpy/k;", "icon", "Lpy/k;", "f", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "title", RXScreenCaptureService.KEY_INDEX, d.f25925o, "text", "h", "setText", "buttonText", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setButtonText", "defaultSchema", "d", "setDefaultSchema", "", "closePanelAfterSchemaJump", "Z", "c", "()Z", "setClosePanelAfterSchemaJump", "(Z)V", "isDefault", ce.f26396k, "setDefault", "", "trackingParams", "Ljava/util/Map;", ce.f26395j, "()Ljava/util/Map;", "setTrackingParams", "(Ljava/util/Map;)V", "extra", "e", "setExtra", "buttonTrackingEventName", "b", "setButtonTrackingEventName", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C2159a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient String f136238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public transient boolean f136239b;

        @SerializedName("button_text")
        protected String buttonText;

        @SerializedName("button_tracking_event_name")
        protected String buttonTrackingEventName;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public transient boolean f136240c;

        @SerializedName("close_panel_after_schema_jump")
        protected boolean closePanelAfterSchemaJump;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f136241d;

        @SerializedName("default_schema")
        protected String defaultSchema;

        @SerializedName("extra")
        protected String extra;

        @SerializedName("icon")
        protected k icon;

        @SerializedName("is_default")
        protected boolean isDefault;

        @SerializedName("item_id")
        protected String itemId;

        @SerializedName("text")
        protected String text;

        @SerializedName("title")
        protected String title;

        @SerializedName("tracking_params")
        protected Map<String, String> trackingParams;

        public C2159a() {
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
        public C2159a(g r110) {
            this.trackingParams = new HashMap();
            long r100 = r110.c();
        L3:
            int r101 = r110.f();
            if (r101 == (-1)) goto L35;
            switch(r101) {
                case 1: goto L34;
                case 2: goto L33;
                case 3: goto L32;
                case 4: goto L31;
                case 5: goto L30;
                case 6: goto L29;
                case 7: goto L28;
                case 8: goto L27;
                case 9: goto L26;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            this.extra = am3.h.c(r110);
            goto L3
        L8:
            long r102 = r110.c();
            String r103 = null;
            String r104 = null;
        L9:
            int r105 = r110.f();
            if (r105 == (-1)) goto L18;
            if (r105 != 1) goto L14;
            r103 = am3.h.c(r110);
            goto L9
        L14:
            if (r105 != 2) goto L15;
            r104 = am3.h.c(r110);
            goto L9
        L15:
            am3.h.e(r110);
            goto L9
        L18:
            r110.d(r102);
            Map<String, String> r106 = this.trackingParams;
            if (r103 == null) goto L25;
            if (r104 == null) goto L23;
            r106.put(r103, r104);
            goto L3
        L23:
            throw new IllegalStateException("Value must not be null");
        L25:
            throw new IllegalStateException("Key must not be null");
        L26:
            this.isDefault = am3.h.a(r110);
            goto L3
        L27:
            this.closePanelAfterSchemaJump = am3.h.a(r110);
            goto L3
        L28:
            this.buttonTrackingEventName = am3.h.c(r110);
            goto L3
        L29:
            this.defaultSchema = am3.h.c(r110);
            goto L3
        L30:
            this.buttonText = am3.h.c(r110);
            goto L3
        L31:
            this.text = am3.h.c(r110);
            goto L3
        L32:
            this.title = am3.h.c(r110);
            goto L3
        L33:
            this.icon = f.a(r110, k.class);
            goto L3
        L34:
            this.itemId = am3.h.c(r110);
            goto L3
        L6:
            am3.h.e(r110);
            goto L3
        L35:
            r110.d(r100);
        }

        public final String a() {
            return this.buttonText;
        }

        public final String b() {
            return this.buttonTrackingEventName;
        }

        public final boolean c() {
            return this.closePanelAfterSchemaJump;
        }

        public final String d() {
            return this.defaultSchema;
        }

        public final String e() {
            return this.extra;
        }

        public final k f() {
            return this.icon;
        }

        public final String g() {
            return this.itemId;
        }

        public final String h() {
            return this.text;
        }

        public final String i() {
            return this.title;
        }

        public final Map<String, String> j() {
            return this.trackingParams;
        }

        public final boolean k() {
            return this.isDefault;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/share/model/a$b;", "", "", "itemType", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setItemType", "(Ljava/lang/String;)V", "", "Lcom/bytedance/android/livesdk/interactivity/comment/share/model/a$a;", "itemList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setItemList", "(Ljava/util/List;)V", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements h {

        @SerializedName("item_list")
        protected List<C2159a> itemList;

        @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
        protected String itemType;

        public b() {
        }

        public b(g r100) {
            this.itemList = new ArrayList();
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.itemType = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.itemList.add(new C2159a(r100));
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }

        public final List<C2159a> a() {
            return this.itemList;
        }

        public final String b() {
            return this.itemType;
        }
    }

    public a() {
    }

    public a(g r100) {
        this.shareDataList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.shareDataList.add(new b(r100));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }

    public final List<b> a() {
        return this.shareDataList;
    }
}
