package com.android.contacts.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PopMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/android/contacts/widget/PopMenuItem;", "", "id", "", "icon", "title", "", "desc", "(IILjava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getIcon", "()I", "getId", "getTitle", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class PopMenuItem {
    private final String desc;
    private final int icon;
    private final int id;
    private final String title;

    public PopMenuItem(int r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "title");
        this(r9, r10, r11, null, 8, null);
    }

    public PopMenuItem(int r2, int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r5, "desc");
        this.id = r2;
        this.icon = r3;
        this.title = r4;
        this.desc = r5;
    }

    public /* synthetic */ PopMenuItem(int r1, int r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = "";
    L5:
        this(r1, r2, r3, r4);
    }

    public final int getId() {
        return this.id;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDesc() {
        return this.desc;
    }
}
