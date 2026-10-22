package androidx.fragment.app;

import android.util.Log;
import androidx.activity.result.ActivityResult;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class P implements androidx.activity.result.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3635a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Y f3636b;

    public /* synthetic */ P(Y y4, int i4) {
        this.f3635a = i4;
        this.f3636b = y4;
    }

    public final void a(ActivityResult activityResult) {
        int i4 = this.f3635a;
        Y y4 = this.f3636b;
        switch (i4) {
            case 1:
                FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo = (FragmentManager$LaunchedFragmentInfo) y4.f3651D.pollFirst();
                if (fragmentManager$LaunchedFragmentInfo != null) {
                    String str = fragmentManager$LaunchedFragmentInfo.f3593a;
                    D dC = y4.f3664c.c(str);
                    if (dC != null) {
                        dC.onActivityResult(fragmentManager$LaunchedFragmentInfo.f3594b, activityResult.f2410a, activityResult.f2411b);
                        break;
                    } else {
                        Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
                        break;
                    }
                } else {
                    Log.w("FragmentManager", "No Activities were started for result for " + this);
                    break;
                }
            default:
                FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo2 = (FragmentManager$LaunchedFragmentInfo) y4.f3651D.pollFirst();
                if (fragmentManager$LaunchedFragmentInfo2 != null) {
                    String str2 = fragmentManager$LaunchedFragmentInfo2.f3593a;
                    D dC2 = y4.f3664c.c(str2);
                    if (dC2 != null) {
                        dC2.onActivityResult(fragmentManager$LaunchedFragmentInfo2.f3594b, activityResult.f2410a, activityResult.f2411b);
                        break;
                    } else {
                        Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str2);
                        break;
                    }
                } else {
                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                    break;
                }
        }
    }

    public final void b(Object obj) {
        switch (this.f3635a) {
            case 0:
                Map map = (Map) obj;
                String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    iArr[i4] = ((Boolean) arrayList.get(i4)).booleanValue() ? 0 : -1;
                }
                Y y4 = this.f3636b;
                FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo = (FragmentManager$LaunchedFragmentInfo) y4.f3651D.pollFirst();
                if (fragmentManager$LaunchedFragmentInfo == null) {
                    Log.w("FragmentManager", "No permissions were requested for " + this);
                    break;
                } else {
                    String str = fragmentManager$LaunchedFragmentInfo.f3593a;
                    D dC = y4.f3664c.c(str);
                    if (dC == null) {
                        Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
                        break;
                    } else {
                        dC.onRequestPermissionsResult(fragmentManager$LaunchedFragmentInfo.f3594b, strArr, iArr);
                        break;
                    }
                }
            case 1:
                a((ActivityResult) obj);
                break;
            default:
                a((ActivityResult) obj);
                break;
        }
    }
}
