package bolts;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class AggregateException extends Exception {
    private static final long serialVersionUID = 1;
    private List<Throwable> innerThrowables;

    public Throwable[] getCauses() {
        List<Throwable> r100 = this.innerThrowables;
        return (Throwable[]) r100.toArray(new Throwable[r100.size()]);
    }

    public List<Exception> getErrors() {
        ArrayList r100 = new ArrayList();
        List<Throwable> r101 = this.innerThrowables;
        if (r101 != null) goto L5;
        return r100;
    L5:
        Iterator<Throwable> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        Throwable r103 = r102.next();
        if ((r103 instanceof Exception) == true) goto L10;
        r100.add(new Exception(r103));
        goto L7
    L10:
        r100.add((Exception) r103);
        goto L7
    L12:
        return r100;
    }

    public List<Throwable> getInnerThrowables() {
        return this.innerThrowables;
    }

    public AggregateException(List<? extends Throwable> r100) {
        this("There were multiple errors.", r100);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream r100) {
        super.printStackTrace(r100);
        Iterator<Throwable> r101 = this.innerThrowables.iterator();
        int r102 = -1;
    L4:
        if (r101.hasNext() == false) goto L6;
        Throwable r103 = r101.next();
        r100.append("\n");
        r100.append("  Inner throwable #");
        r102 = r102 + 1;
        r100.append(Integer.toString(r102));
        r100.append(": ");
        r103.printStackTrace(r100);
        r100.append("\n");
        goto L4
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter r100) {
        super.printStackTrace(r100);
        Iterator<Throwable> r101 = this.innerThrowables.iterator();
        int r102 = -1;
    L4:
        if (r101.hasNext() == false) goto L6;
        Throwable r103 = r101.next();
        r100.append("\n");
        r100.append("  Inner throwable #");
        r102 = r102 + 1;
        r100.append(Integer.toString(r102));
        r100.append(": ");
        r103.printStackTrace(r100);
        r100.append("\n");
        goto L4
    }

    public AggregateException(String r100, List<? extends Throwable> r101) {
        if (r101 != null) goto L4;
    L6:
        Throwable r102 = null;
    L7:
        super(r100, r102);
        this.innerThrowables = Collections.unmodifiableList(r101);
        return;
    L4:
        if (r101.size() <= 0) goto L6;
        r102 = (Throwable) ListProtector.get(r101, 0);
        goto L7
    }

    public AggregateException(String r100, Throwable[] r101) {
        this(r100, Arrays.asList(r101));
    }
}
