package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class TaskStackBuilder implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f2464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f2465b;

    public interface SupportParentable {
        @Nullable
        Intent getSupportParentActivityIntent();
    }

    public TaskStackBuilder(Context r10) {
        this.f2464a = new ArrayList();
        this.f2465b = r10;
    }

    public static TaskStackBuilder e(Context r10) {
        return new TaskStackBuilder(r10);
    }

    public TaskStackBuilder a(Intent r10) {
        this.f2464a.add(r10);
        return this;
    }

    public TaskStackBuilder b(Intent r10) {
        ComponentName r11 = r10.getComponent();
        if (r11 != null) goto L5;
        r11 = r10.resolveActivity(this.f2465b.getPackageManager());
    L5:
        if (r11 == null) goto L7;
        d(r11);
    L7:
        a(r10);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TaskStackBuilder c(Activity r10) {
        if ((r10 instanceof SupportParentable) == false) goto L5;
        Intent r11 = ((SupportParentable) r10).getSupportParentActivityIntent();
    L6:
        if (r11 != null) goto L8;
        r11 = f.a(r10);
    L8:
        if (r11 == null) goto L13;
        ComponentName r12 = r11.getComponent();
        if (r12 != null) goto L12;
        r12 = r11.resolveActivity(this.f2465b.getPackageManager());
    L12:
        d(r12);
        a(r11);
    L13:
        return this;
    L5:
        r11 = null;
        goto L6
    }

    public TaskStackBuilder d(ComponentName r10) {
        int r11 = this.f2464a.size();
        Intent r12 = f.b(this.f2465b, r10);     // Catch: PackageManager.NameNotFoundException -> L7
    L4:
        if (r12 == null) goto L9;
        this.f2464a.add(r11, r12);     // Catch: PackageManager.NameNotFoundException -> L7
        r12 = f.b(this.f2465b, r12.getComponent());     // Catch: PackageManager.NameNotFoundException -> L7
        goto L4
    L9:
        return this;
    L7:
        e = move-exception;
        Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
        throw new IllegalArgumentException(e);
    }

    public void f() {
        g(null);
    }

    public void g(Bundle r10) {
        if (this.f2464a.isEmpty() == true) goto L9;
        Intent[] r11 = (Intent[]) this.f2464a.toArray(new Intent[0]);
        r11[0] = new Intent(r11[0]).addFlags(268484608);
        if (ContextCompat.j(this.f2465b, r11, r10) == true) goto L10;
        Intent r12 = new Intent(r11[r11.length - 1]);
        r12.addFlags(268435456);
        this.f2465b.startActivity(r12);
        return;
    L10:
        return;
    L9:
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f2464a.iterator();
    }
}
