package com.android.contacts.calllog.blocked;

import android.content.ContentResolver;
import android.os.AsyncTask;
import android.provider.CallLog;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeleteBlockedCallTask.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0001B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ3\u0010\u000f\u001a\u0004\u0018\u00010\u00042\"\u0010\u0010\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0011\"\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/android/contacts/calllog/blocked/DeleteBlockedCallTask;", "Landroid/os/AsyncTask;", "", "", "Ljava/lang/Void;", "contentResolver", "Landroid/content/ContentResolver;", "onTaskDone", "Lkotlin/Function0;", "", "(Landroid/content/ContentResolver;Lkotlin/jvm/functions/Function0;)V", "getContentResolver", "()Landroid/content/ContentResolver;", "getOnTaskDone", "()Lkotlin/jvm/functions/Function0;", "doInBackground", "params", "", "([Ljava/util/Set;)Ljava/lang/Void;", "onPostExecute", "aVoid", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DeleteBlockedCallTask extends AsyncTask<Set<? extends Long>, Void, Void> {
    private final ContentResolver contentResolver;
    private final Function0<Unit> onTaskDone;

    public DeleteBlockedCallTask(ContentResolver r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "contentResolver");
        this.contentResolver = r2;
        this.onTaskDone = r3;
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ Void doInBackground(Set<? extends Long>[] r1) {
        return doInBackground2(r1);
    }

    public final ContentResolver getContentResolver() {
        return this.contentResolver;
    }

    public final Function0<Unit> getOnTaskDone() {
        return this.onTaskDone;
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
        onPostExecute2(r1);
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected Void doInBackground2(Set<Long>... r8) {
        Intrinsics.checkNotNullParameter(r8, "params");
        Set r9 = (Set) ArraysKt.getOrNull(r8, 0);
        if (r9 != null) goto L5;
    L16:
        return null;
    L5:
        if (r9.isEmpty() == true) goto L16;
        StringBuilder r2 = new StringBuilder("_id IN (");
        Iterator r10 = r9.iterator();
        boolean r3 = true;
    L9:
        if (r10.hasNext() == false) goto L15;
        long r4 = ((Number) r10.next()).longValue();
        if (r3 == false) goto L13;
        r3 = false;
    L14:
        r2.append(r4);
        goto L9
    L13:
        r2.append(", ");
        goto L14
    L15:
        r2.append(")");
        this.contentResolver.delete(CallLog.Calls.CONTENT_URI, r2.toString(), null);
        goto L16
    }

    /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    protected void onPostExecute2(Void r1) {
        Function0<Unit> r0 = this.onTaskDone;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }
}
