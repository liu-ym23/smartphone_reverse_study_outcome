package K8;

import K8.b;
import Yb.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import u8.e;

/* loaded from: classes4.dex */
public abstract class a extends RecyclerView.Adapter<c> {

    /* renamed from: K8.a$a, reason: collision with other inner class name */
    public interface InterfaceC0066a {
        <N extends u> InterfaceC0066a a(Class<N> cls, b<? super N, ? extends c> bVar);

        a build();
    }

    public static abstract class b<N extends u, H extends c> {
        public abstract void a(e eVar, H h10, N n10);

        public void b() {
        }

        public abstract H c(LayoutInflater layoutInflater, ViewGroup viewGroup);

        public long d(N n10) {
            return n10.hashCode();
        }

        public void e(H h10) {
        }
    }

    public static class c extends RecyclerView.ViewHolder {
        public c(View view) {
            super(view);
        }

        public <V extends View> V a(int i10) {
            String strValueOf;
            V v10 = (V) this.itemView.findViewById(i10);
            if (v10 != null) {
                return v10;
            }
            if (i10 == 0 || i10 == -1) {
                strValueOf = String.valueOf(i10);
            } else {
                strValueOf = "R.id." + this.itemView.getResources().getResourceName(i10);
            }
            throw new NullPointerException(String.format("No view with id(R.id.%s) is found in layout: %s", strValueOf, this.itemView));
        }
    }

    public static InterfaceC0066a c(b<? extends u, ? extends c> bVar) {
        return new b.a(bVar);
    }

    public static InterfaceC0066a d(int i10) {
        return c(K8.c.h(i10));
    }

    public abstract void e(e eVar, String str);
}
