package com.android.contacts.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MenuUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/android/contacts/util/MenuItem;", "", "title", "", "headImageRes", "", "tailImageRes", "onClick", "Lkotlin/Function0;", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "getHeadImageRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getTailImageRes", "getTitle", "()Ljava/lang/String;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MenuItem {
    private final Integer headImageRes;
    private final Function0<Unit> onClick;
    private final Integer tailImageRes;
    private final String title;

    public MenuItem(String r2, Integer r3, Integer r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r5, "onClick");
        this.title = r2;
        this.headImageRes = r3;
        this.tailImageRes = r4;
        this.onClick = r5;
    }

    public /* synthetic */ MenuItem(String r2, Integer r3, Integer r4, AnonymousClass1 r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = AnonymousClass1.INSTANCE;
    L11:
        this(r2, r3, r4, r5);
    }

    public final Integer getHeadImageRes() {
        return this.headImageRes;
    }

    public final Function0<Unit> getOnClick() {
        return this.onClick;
    }

    public final Integer getTailImageRes() {
        return this.tailImageRes;
    }

    public final String getTitle() {
        return this.title;
    }
}
