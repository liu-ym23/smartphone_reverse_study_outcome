package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.AdminPrivilegeMessage")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/k;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdk/message/model/k$a;", "info", "Lcom/bytedance/android/livesdk/message/model/k$a;", ExifInterface.LONGITUDE_EAST, "()Lcom/bytedance/android/livesdk/message/model/k$a;", "setInfo", "(Lcom/bytedance/android/livesdk/message/model/k$a;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k extends o0 implements vh7.h {

    @SerializedName("data")
    protected a info;

    @ProtoMessage("webcast.im.AdminPrivilegeStruct")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/k$a;", "", "", "privilege", "I", "c", "()I", "setPrivilege", "(I)V", "op", "b", "setOp", "", "curPrivileges", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setCurPrivileges", "(Ljava/util/List;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("current_privileges")
        protected List<Integer> curPrivileges;

        /* JADX INFO: renamed from: op, reason: collision with root package name */
        @SerializedName("op")
        protected int f153659op;

        @SerializedName("privilege")
        protected int privilege;

        public a() {
            this.curPrivileges = new ArrayList();
        }

        public final List<Integer> a() {
            return this.curPrivileges;
        }

        public final int b() {
            return this.f153659op;
        }

        public final int c() {
            return this.privilege;
        }

        public a(am3.g r100) {
            this.curPrivileges = new ArrayList();
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            if (r102 != 1) goto L8;
            this.privilege = r100.i();
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.f153659op = (int) r100.j();
            goto L3
        L10:
            if (r102 != 3) goto L11;
            this.curPrivileges.add(Integer.valueOf(r100.i()));
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
            if (this.curPrivileges.isEmpty() == false) goto L31;
            this.curPrivileges = new ArrayList();
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public final String toString() {
        a r100 = this.info;
        if (r100 != null) goto L5;
        return "AdminPrivilegeMessage(info=null)";
    L5:
        Intrinsics.checkNotNull(r100);
        String r101 = "";
        if (r100.f153659op != 1) goto L8;
        String r102 = "1(ADD)";
    L15:
        a r103 = this.info;
        Intrinsics.checkNotNull(r103);
        if (r103.curPrivileges == null) goto L18;
        a r104 = this.info;
        Intrinsics.checkNotNull(r104);
        r101 = String.valueOf(r104.curPrivileges);
    L18:
        StringBuilder r105 = new StringBuilder("AdminPrivilegeMessage(info=AdminPrivilegeStruct(privilege=");
        a r106 = this.info;
        Intrinsics.checkNotNull(r106);
        r105.append(r106.privilege);
        r105.append(", op=");
        r105.append(r102);
        r105.append(", curPrivileges=");
        r105.append(r101);
        r105.append(")");
        return r105.toString();
    L8:
        a r107 = this.info;
        Intrinsics.checkNotNull(r107);
        if (r107.f153659op != 2) goto L11;
        r102 = "2(REMOVE)";
        goto L15
    L11:
        a r108 = this.info;
        Intrinsics.checkNotNull(r108);
        if (r108.f153659op != 3) goto L14;
        r102 = "3(UPDATE)";
        goto L15
    L14:
        r102 = "";
        goto L15
    }

    public k() {
        this.type = MessageType.ADMIN_PRIVILEGE_CHANGE;
    }

    public final a E() {
        return this.info;
    }

    public k(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.info = new a(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        this.type = MessageType.ADMIN_PRIVILEGE_CHANGE;
    }
}
