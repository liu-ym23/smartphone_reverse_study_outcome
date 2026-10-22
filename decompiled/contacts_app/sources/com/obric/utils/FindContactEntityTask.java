package com.obric.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.os.AsyncTask;
import com.android.contacts.numberassistant.NumberInfosManager;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.contactsdk.loader.ContactEntityUtilKt;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: FindContactEntityTask.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u00002$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u0001BA\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012*\u0010\t\u001a&\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0002\u0010\fJ5\u0010\u0013\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0015\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J \u0010\u0019\u001a\u00020\u00022\u0016\u0010\u001a\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0014R5\u0010\t\u001a&\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/obric/utils/FindContactEntityTask;", "Landroid/os/AsyncTask;", "", "Lkotlin/Pair;", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "", "context", "Landroid/content/Context;", "phoneNumber", "callback", "Lkotlin/Function2;", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getContext", "()Landroid/content/Context;", "getPhoneNumber", "()Ljava/lang/String;", "doInBackground", "params", "", "([Lkotlin/Unit;)Lkotlin/Pair;", "getNumberLabel", "number", "onPostExecute", "result", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FindContactEntityTask extends AsyncTask<Unit, Unit, Pair<? extends ContactEntity, ? extends String>> {
    private final Function2<Pair<ContactEntity, String>, Object, Unit> callback;
    private final Context context;
    private final String phoneNumber;

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ Pair<? extends ContactEntity, ? extends String> doInBackground(Unit[] r1) {
        return doInBackground2(r1);
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(Pair<? extends ContactEntity, ? extends String> r1) {
        onPostExecute2(r1);
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final Function2<Pair<ContactEntity, String>, Object, Unit> getCallback() {
        return this.callback;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FindContactEntityTask(Context r2, String r3, Function2<? super Pair<ContactEntity, String>, Object, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "phoneNumber");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.context = r2;
        this.phoneNumber = r3;
        this.callback = r4;
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected Pair<ContactEntity, String> doInBackground2(Unit... r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        ContentResolver r5 = this.context.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r5, "context.contentResolver");
        String r6 = ContactEntityUtilKt.getContactIdByPhoneNumber(r5, this.phoneNumber);
        if (r6 == null) goto L5;
        long r1 = Long.parseLong(r6);
    L6:
        List r7 = CollectionsKt.listOf(Long.valueOf(r1));
        ContentResolver r2 = this.context.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r2, "context.contentResolver");
        ContactEntity r8 = (ContactEntity) CollectionsKt.getOrNull(ContactEntityUtilKt.queryContactsByIds(r2, r7, false, false), 0);
        if (r8 != null) goto L9;
        String r3 = getNumberLabel(this.phoneNumber);
    L11:
        return new Pair(r8, r3);
    L9:
        r3 = null;
        goto L11
    L5:
        r1 = -1;
        goto L6
    }

    /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    protected void onPostExecute2(Pair<ContactEntity, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        this.callback.invoke(r2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String getNumberLabel(String r4) {
        final Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = "";
        final CountDownLatch r0 = new CountDownLatch(1);
        NumberInfosManager.getInstance().getBaseAndMarkInfos(r4, new AnonymousClass1(r3, r0));
        r0.await(3, TimeUnit.SECONDS);
        return (String) r3.element;
    }
}
