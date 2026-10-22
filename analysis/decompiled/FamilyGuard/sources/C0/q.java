package C0;

import android.util.Log;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.libpag.BuildConfig;
import z0.EnumC1335a;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
public final class q extends Exception {

    /* renamed from: g, reason: collision with root package name */
    private static final StackTraceElement[] f471g = new StackTraceElement[0];

    /* renamed from: a, reason: collision with root package name */
    private final List<Throwable> f472a;

    /* renamed from: b, reason: collision with root package name */
    private InterfaceC1340f f473b;

    /* renamed from: c, reason: collision with root package name */
    private EnumC1335a f474c;

    /* renamed from: d, reason: collision with root package name */
    private Class<?> f475d;

    /* renamed from: e, reason: collision with root package name */
    private String f476e;

    /* renamed from: f, reason: collision with root package name */
    private Exception f477f;

    public q(String str) {
        this(str, (List<Throwable>) Collections.EMPTY_LIST);
    }

    private void a(Throwable th, List<Throwable> list) {
        if (!(th instanceof q)) {
            list.add(th);
            return;
        }
        Iterator<Throwable> it = ((q) th).e().iterator();
        while (it.hasNext()) {
            a(it.next(), list);
        }
    }

    private static void b(List<Throwable> list, Appendable appendable) {
        try {
            c(list, appendable);
        } catch (IOException e6) {
            throw new RuntimeException(e6);
        }
    }

    private static void c(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i5 = 0;
        while (i5 < size) {
            int i6 = i5 + 1;
            appendable.append("Cause (").append(String.valueOf(i6)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i5);
            if (th instanceof q) {
                ((q) th).h(appendable);
            } else {
                d(th, appendable);
            }
            i5 = i6;
        }
    }

    private static void d(Throwable th, Appendable appendable) throws IOException {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private void h(Appendable appendable) throws IOException {
        d(this, appendable);
        b(e(), new a(appendable));
    }

    public List<Throwable> e() {
        return this.f472a;
    }

    public List<Throwable> f() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public void g(String str) {
        List<Throwable> listF = f();
        int size = listF.size();
        int i5 = 0;
        while (i5 < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i6 = i5 + 1;
            sb.append(i6);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(str, sb.toString(), listF.get(i5));
            i5 = i6;
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f476e);
        Class<?> cls = this.f475d;
        String str = BuildConfig.FLAVOR;
        sb.append(cls != null ? ", " + this.f475d : BuildConfig.FLAVOR);
        sb.append(this.f474c != null ? ", " + this.f474c : BuildConfig.FLAVOR);
        if (this.f473b != null) {
            str = ", " + this.f473b;
        }
        sb.append(str);
        List<Throwable> listF = f();
        if (listF.isEmpty()) {
            return sb.toString();
        }
        if (listF.size() == 1) {
            sb.append("\nThere was 1 cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(listF.size());
            sb.append(" causes:");
        }
        for (Throwable th : listF) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    void i(InterfaceC1340f interfaceC1340f, EnumC1335a enumC1335a) {
        j(interfaceC1340f, enumC1335a, null);
    }

    void j(InterfaceC1340f interfaceC1340f, EnumC1335a enumC1335a, Class<?> cls) {
        this.f473b = interfaceC1340f;
        this.f474c = enumC1335a;
        this.f475d = cls;
    }

    public void k(Exception exc) {
        this.f477f = exc;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() throws IOException {
        printStackTrace(System.err);
    }

    public q(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) throws IOException {
        h(printStream);
    }

    public q(String str, List<Throwable> list) {
        this.f476e = str;
        setStackTrace(f471g);
        this.f472a = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) throws IOException {
        h(printWriter);
    }

    private static final class a implements Appendable {

        /* renamed from: a, reason: collision with root package name */
        private final Appendable f478a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f479b = true;

        a(Appendable appendable) {
            this.f478a = appendable;
        }

        private CharSequence a(CharSequence charSequence) {
            return charSequence == null ? BuildConfig.FLAVOR : charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c6) throws IOException {
            if (this.f479b) {
                this.f479b = false;
                this.f478a.append("  ");
            }
            this.f479b = c6 == '\n';
            this.f478a.append(c6);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            CharSequence charSequenceA = a(charSequence);
            return append(charSequenceA, 0, charSequenceA.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i5, int i6) throws IOException {
            CharSequence charSequenceA = a(charSequence);
            boolean z5 = false;
            if (this.f479b) {
                this.f479b = false;
                this.f478a.append("  ");
            }
            if (charSequenceA.length() > 0 && charSequenceA.charAt(i6 - 1) == '\n') {
                z5 = true;
            }
            this.f479b = z5;
            this.f478a.append(charSequenceA, i5, i6);
            return this;
        }
    }
}
