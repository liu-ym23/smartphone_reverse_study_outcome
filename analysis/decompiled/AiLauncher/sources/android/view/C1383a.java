package android.view;

import android.app.Application;
import io.ktor.http.ContentType;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/lifecycle/a;", "Landroidx/lifecycle/Q;", "Landroid/app/Application;", ContentType.Application.TYPE, "<init>", "(Landroid/app/Application;)V", "Landroid/app/Application;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: androidx.lifecycle.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1383a extends Q {
    private final Application application;

    public C1383a(Application application) {
        p.i(application, "application");
        this.application = application;
    }
}
