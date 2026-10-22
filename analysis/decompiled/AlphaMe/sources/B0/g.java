package B0;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.datastore.preferences.protobuf.AbstractC0268o;
import androidx.fragment.app.D;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.utils.Property;
import java.util.List;

/* loaded from: classes.dex */
public abstract /* synthetic */ class g {
    public static int A(int i4, int i5, int i6, int i7) {
        return AbstractC0268o.E(i4) + i5 + i6 + i7;
    }

    public static /* synthetic */ String B(int i4) {
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? i4 != 5 ? "null" : "ExcludeIntersections" : "Intersect" : "Subtract" : "Add" : "Merge";
    }

    public static /* synthetic */ String C(int i4) {
        switch (i4) {
            case 1:
                return "PreComp";
            case 2:
                return "Solid";
            case 3:
                return "Image";
            case 4:
                return "Null";
            case 5:
                return "Shape";
            case 6:
                return "Text";
            case 7:
                return "Unknown";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String D(int i4) {
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? "null" : "DROP_LATEST" : "DROP_OLDEST" : "SUSPEND";
    }

    public static /* synthetic */ String E(int i4) {
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? "null" : "REMOVING" : "ADDING" : "NONE";
    }

    public static /* synthetic */ String F(int i4) {
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? "null" : "INVISIBLE" : "GONE" : "VISIBLE" : "REMOVED";
    }

    public static final void a(int i4, View view) {
        int iA = t.h.a(i4);
        if (iA == 0) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                }
                viewGroup.removeView(view);
                return;
            }
            return;
        }
        if (iA == 1) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
            }
            view.setVisibility(0);
            return;
        }
        if (iA == 2) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
            }
            view.setVisibility(8);
            return;
        }
        if (iA != 3) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
        }
        view.setVisibility(4);
    }

    public static int b(int i4) {
        if (i4 == 0) {
            return 2;
        }
        if (i4 == 4) {
            return 4;
        }
        if (i4 == 8) {
            return 3;
        }
        throw new IllegalArgumentException(AbstractC0351g.m("Unknown visibility ", i4));
    }

    public static int c(View view) {
        if (view.getAlpha() == Property.DEFAULT_FLOAT_VALUE && view.getVisibility() == 0) {
            return 4;
        }
        return b(view.getVisibility());
    }

    public static int d(int i4, int i5, int i6) {
        return (Integer.hashCode(i4) + i5) * i6;
    }

    public static int e(int i4, int i5, int i6, int i7) {
        return ((i4 + i5) - i6) - i7;
    }

    public static int f(long j4, int i4, int i5) {
        return (Long.hashCode(j4) + i4) * i5;
    }

    public static int g(Integer num, int i4) {
        return L1.d.k(num.intValue()) + i4;
    }

    public static Object h(List list, int i4) {
        return list.get(list.size() - i4);
    }

    public static String i(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String j(String str, int i4, String str2) {
        return str + i4 + str2;
    }

    public static String k(String str, int i4, String str2, int i5) {
        return str + i4 + str2 + i5;
    }

    public static String l(String str, D d4, String str2) {
        return str + d4 + str2;
    }

    public static String m(String str, String str2) {
        return str + str2;
    }

    public static String n(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String o(StringBuilder sb, int i4, char c4) {
        sb.append(i4);
        sb.append(c4);
        return sb.toString();
    }

    public static String p(StringBuilder sb, long j4, String str) {
        sb.append(j4);
        sb.append(str);
        return sb.toString();
    }

    public static String q(StringBuilder sb, String str, char c4) {
        sb.append(str);
        sb.append(c4);
        return sb.toString();
    }

    public static String r(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder s(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder t(String str, int i4, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i4);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder u(String str, int i4, String str2, int i5, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i4);
        sb.append(str2);
        sb.append(i5);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder v(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder w(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder x(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        sb.append(str5);
        return sb;
    }

    public static /* synthetic */ void y(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static void z(String str, int i4, String str2) {
        Log.d(str2, str + i4);
    }
}
