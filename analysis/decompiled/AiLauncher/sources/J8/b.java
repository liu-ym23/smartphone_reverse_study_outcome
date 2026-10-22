package J8;

import Yb.u;
import Yb.z;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class b extends i {

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f3748e = j.f3761n;

    @Override // J8.i
    public u e() {
        this.f3757d++;
        if (j() == '\n') {
            Yb.k kVar = new Yb.k();
            this.f3757d++;
            return kVar;
        }
        if (this.f3757d < this.f3756c.length()) {
            Pattern pattern = f3748e;
            String str = this.f3756c;
            int i10 = this.f3757d;
            if (pattern.matcher(str.substring(i10, i10 + 1)).matches()) {
                String str2 = this.f3756c;
                int i11 = this.f3757d;
                z zVarP = p(str2, i11, i11 + 1);
                this.f3757d++;
                return zVarP;
            }
        }
        return o("\\");
    }

    @Override // J8.i
    public char m() {
        return '\\';
    }
}
