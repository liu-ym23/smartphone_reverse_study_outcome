package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.room.TempStateAreaResponse.TempStateAreaData")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0006\rB\u0007¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/v3;", "", "", "Lcom/bytedance/android/livesdk/chatroom/model/v3$a;", "elemList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setElemList", "(Ljava/util/List;)V", "", "maxShowCount", "J", "b", "()J", "setMaxShowCount", "(J)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v3 implements vh7.h {

    @SerializedName("elems")
    protected List<a> elemList;

    @SerializedName("max_show_count")
    protected long maxShowCount;

    @ProtoMessage("webcast.api.room.TempStateAreaResponse.Elem")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/v3$a;", "", "", "elementType", "J", "b", "()J", "setElementType", "(J)V", "elementId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setElementId", "itemId", "c", "setItemId", "Lcom/bytedance/android/livesdk/chatroom/model/v3$b;", "resource", "Lcom/bytedance/android/livesdk/chatroom/model/v3$b;", "d", "()Lcom/bytedance/android/livesdk/chatroom/model/v3$b;", "setResource", "(Lcom/bytedance/android/livesdk/chatroom/model/v3$b;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("elem_id")
        protected long elementId;

        @SerializedName("elem_type")
        protected long elementType;

        @SerializedName("item_id")
        protected long itemId;

        @SerializedName("resource")
        protected b resource;

        public a() {
        }

        public final long a() {
            return this.elementId;
        }

        public final long b() {
            return this.elementType;
        }

        public final long c() {
            return this.itemId;
        }

        public final b d() {
            return this.resource;
        }

        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            if (r102 != 1) goto L8;
            this.elementType = r100.j();
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.elementId = r100.j();
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.itemId = r100.j();
            goto L3
        L12:
            if (r102 != 4) goto L13;
            this.resource = new b(r100);
            goto L3
        L13:
            am3.h.e(r100);
            goto L3
        L18:
            r100.d(r101);
        }
    }

    @ProtoMessage("webcast.api.room.TempStateAreaResponse.Resource")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/v3$b;", "", "", "name", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "icon", "b", "setIcon", "description", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDescription", "extra", "getExtra", "setExtra", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements vh7.h {

        @SerializedName("description")
        protected String description;

        @SerializedName("extra")
        protected String extra;

        @SerializedName("icon")
        protected String icon;

        @SerializedName("name")
        protected String name;

        public b() {
            this.name = "";
            this.icon = "";
            this.description = "";
            this.extra = "";
        }

        public final String a() {
            return this.description;
        }

        public final String b() {
            return this.icon;
        }

        public final String c() {
            return this.name;
        }

        public b(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            if (r102 != 1) goto L8;
            this.name = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.icon = am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.description = am3.h.c(r100);
            goto L3
        L12:
            if (r102 != 4) goto L13;
            this.extra = am3.h.c(r100);
            goto L3
        L13:
            am3.h.e(r100);
            goto L3
        L18:
            r100.d(r101);
            if (this.name != null) goto L22;
            this.name = "";
        L22:
            if (this.icon != null) goto L25;
            this.icon = "";
        L25:
            if (this.description != null) goto L28;
            this.description = "";
        L28:
            if (this.extra != null) goto L46;
            this.extra = "";
            return;
        }
    }

    public v3() {
        this.maxShowCount = 8;
    }

    public final List<a> a() {
        return this.elemList;
    }

    public final long b() {
        return this.maxShowCount;
    }

    public v3(am3.g r100) {
        this.elemList = new ArrayList();
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L11;
        if (r103 != 1) goto L7;
        this.elemList.add(new a(r100));
        goto L3
    L7:
        if (r103 != 2) goto L8;
        this.maxShowCount = r100.j();
        r102 = r102 | true;
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L11:
        r100.d(r101);
        if ((r102 & true) == true) goto L24;
        this.maxShowCount = 8;
        return;
    }
}
