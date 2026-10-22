package com.obric.contactsdk;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContactChange.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rR\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/contactsdk/ContactChange;", "", "()V", "listenerChangeList", "Ljava/util/ArrayList;", "Lcom/obric/contactsdk/ContactChangeListener;", "Lkotlin/collections/ArrayList;", "addChangeListener", "", "listener", "removeChangeListener", "update", "uris", "", "Landroid/net/Uri;", "contactsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactChange {
    public static final ContactChange INSTANCE = null;
    private static final ArrayList<ContactChangeListener> listenerChangeList = null;

    private ContactChange() {
    }

    static {
        INSTANCE = new ContactChange();
        listenerChangeList = new ArrayList();
    }

    public final void addChangeListener(ContactChangeListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        ArrayList<ContactChangeListener> r0 = listenerChangeList;
        monitor-enter(r0);
        r0.add(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void removeChangeListener(ContactChangeListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        ArrayList<ContactChangeListener> r0 = listenerChangeList;
        monitor-enter(r0);
        r0.remove(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void update(List<? extends Uri> r2) {
        Intrinsics.checkNotNullParameter(r2, "uris");
        Iterator<T> r1 = listenerChangeList.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((ContactChangeListener) r1.next()).update(r2);
        goto L4
    }
}
