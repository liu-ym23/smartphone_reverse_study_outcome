package com.obric.utils;

import android.content.Context;
import android.os.AsyncTask;
import com.android.contacts.calllog.ContactInfo;
import com.android.contacts.calllog.ContactInfoHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FindContactTask.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0002\u0010\u000bJ'\u0010\u001c\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u001e\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u001fJ\u0012\u0010 \u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u0003H\u0014R%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u0016\u001a\n \u0017*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019¨\u0006\""}, d2 = {"Lcom/obric/utils/FindContactTask;", "Landroid/os/AsyncTask;", "", "Lcom/android/contacts/calllog/ContactInfo;", "context", "Landroid/content/Context;", "phoneNumber", "", "callback", "Lkotlin/Function2;", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "contactInfoHelper", "Lcom/android/contacts/calllog/ContactInfoHelper;", "getContactInfoHelper", "()Lcom/android/contacts/calllog/ContactInfoHelper;", "contactInfoHelper$delegate", "Lkotlin/Lazy;", "getContext", "()Landroid/content/Context;", "countryIso", "kotlin.jvm.PlatformType", "getCountryIso", "()Ljava/lang/String;", "countryIso$delegate", "getPhoneNumber", "doInBackground", "params", "", "([Lkotlin/Unit;)Lcom/android/contacts/calllog/ContactInfo;", "onPostExecute", "result", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FindContactTask extends AsyncTask<Unit, Unit, ContactInfo> {
    private final Function2<String, Object, Unit> callback;
    private final Lazy contactInfoHelper$delegate;
    private final Context context;
    private final Lazy countryIso$delegate;
    private final String phoneNumber;

    public static final /* synthetic */ String access$getCountryIso(FindContactTask r0) {
        return r0.getCountryIso();
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ ContactInfo doInBackground(Unit[] r1) {
        return doInBackground2(r1);
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(ContactInfo r1) {
        onPostExecute2(r1);
    }

    public final Function2<String, Object, Unit> getCallback() {
        return this.callback;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FindContactTask(Context r2, String r3, Function2<? super String, Object, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "phoneNumber");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.context = r2;
        this.phoneNumber = r3;
        this.callback = r4;
        this.countryIso$delegate = LazyKt.lazy(new FindContactTask$countryIso$2(this));
        this.contactInfoHelper$delegate = LazyKt.lazy(new FindContactTask$contactInfoHelper$2(this));
    }

    private final String getCountryIso() {
        return (String) this.countryIso$delegate.getValue();
    }

    private final ContactInfoHelper getContactInfoHelper() {
        return (ContactInfoHelper) this.contactInfoHelper$delegate.getValue();
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected ContactInfo doInBackground2(Unit... r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        return getContactInfoHelper().lookupNumber(this.phoneNumber, getCountryIso());
    }

    /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    protected void onPostExecute2(ContactInfo r2) {
        if (r2 == null) goto L4;
        String r3 = r2.name;
    L5:
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        if (r3.length() != 0) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        r3 = this.phoneNumber;
    L13:
        this.callback.invoke(r3, this);
        return;
    L10:
        r0 = false;
        goto L11
    L4:
        r3 = null;
        goto L5
    }
}
