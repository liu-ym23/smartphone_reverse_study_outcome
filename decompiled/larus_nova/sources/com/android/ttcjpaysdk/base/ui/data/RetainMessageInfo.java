package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004¢\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\rR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/RetainMessageInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "left_msg", "", "left_msg_type", "", "right_msg", "top_left_msg", "voucher_type", "top_left_position", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "isMsgShowAtLeft", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RetainMessageInfo implements CJPayObject, Serializable {
    public String left_msg;
    public int left_msg_type;
    public String right_msg;
    public String top_left_msg;
    public String top_left_position;
    public int voucher_type;

    public RetainMessageInfo() {
        this(null, 0, null, null, 0, null, 63, null);
    }

    public final boolean isMsgShowAtLeft() {
        return this.top_left_position.equals("left");
    }

    public RetainMessageInfo(String r100, int r101, String r102, String r103, int r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "left_msg");
        Intrinsics.checkNotNullParameter(r102, "right_msg");
        Intrinsics.checkNotNullParameter(r103, "top_left_msg");
        Intrinsics.checkNotNullParameter(r105, "top_left_position");
        this.left_msg = r100;
        this.left_msg_type = r101;
        this.right_msg = r102;
        this.top_left_msg = r103;
        this.voucher_type = r104;
        this.top_left_position = r105;
    }

    public /* synthetic */ RetainMessageInfo(String r100, int r101, String r102, String r103, int r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = "";
    L6:
        int r104 = 0;
        if ((r112 & 2) == 0) goto L9;
        int r105 = 0;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r106 = "";
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r107 = "";
    L19:
        if ((r112 & 16) != 0) goto L23;
        r104 = r110;
    L23:
        if ((r112 & 32) == 0) goto L25;
        String r115 = "";
    L26:
        this(r114, r105, r106, r107, r104, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L6
    }
}
