package com.bytedance.android.scope;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u0000 \u00132\u00060\u0001j\u0002`\u0002:\u0001\u0014B\u001f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/scope/DependencyResolutionError;", "Ljava/lang/Error;", "Lkotlin/Error;", "", "Le33/l;", "dependencyTrace", "Ljava/util/List;", "getDependencyTrace$runtime", "()Ljava/util/List;", "", "_superMessage", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "runtime"}, k = 1, mv = {1, 4, 3})
public final class DependencyResolutionError extends Error {
    public static final a Companion = null;
    private final String _superMessage;
    private final List<e33.l> dependencyTrace;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DependencyResolutionError() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String r100 = this._superMessage;
        if (this.dependencyTrace.isEmpty() == false) goto L5;
        return r100;
    L5:
        String r101 = this._superMessage;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        StringBuilder r102 = new StringBuilder(r101);
        if (getCause() == null) goto L11;
        r102.append("\nInner exception: ");
        r102.append(getCause().toString());
    L11:
        r102.append("\nDependency trace:\n");
        int r103 = this.dependencyTrace.size();
        Iterator r104 = CollectionsKt.asReversedMutable(this.dependencyTrace).iterator();
        int r105 = 0;
    L13:
        if (r104.hasNext() == false) goto L23;
        Object r106 = r104.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        r102.append(((e33.l) r106).toString());
        if (r105 == (r103 - 1)) goto L20;
        r102.append(" ->");
    L21:
        r102.append('\n');
        r105 = r107;
        goto L13
    L20:
        r102.append(" *");
        goto L21
    L23:
        return r102.toString();
    }

    public final List<e33.l> getDependencyTrace$runtime() {
        return this.dependencyTrace;
    }

    public DependencyResolutionError(String r100, Throwable r101) {
        super(r100, r101);
        this.dependencyTrace = new ArrayList();
        this._superMessage = r100;
    }

    public /* synthetic */ DependencyResolutionError(String r100, Throwable r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
