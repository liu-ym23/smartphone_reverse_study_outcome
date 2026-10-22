package j2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.stepos.common.widget.LoadingView;
import com.stepos.common.widget.StepOSButton;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.MyRecyclerView;
import com.stepos.widget.toolbar.StepOSTitleBar;
import i0.C0756a;

/* renamed from: j2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0785b {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f17676a;

    /* renamed from: b, reason: collision with root package name */
    public final Group f17677b;

    /* renamed from: c, reason: collision with root package name */
    public final StepOSButton f17678c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f17679d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f17680e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f17681f;

    /* renamed from: g, reason: collision with root package name */
    public final Group f17682g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f17683h;

    /* renamed from: i, reason: collision with root package name */
    public final LoadingView f17684i;

    /* renamed from: j, reason: collision with root package name */
    public final View f17685j;

    /* renamed from: k, reason: collision with root package name */
    public final MyRecyclerView f17686k;

    /* renamed from: l, reason: collision with root package name */
    public final StepOSTitleBar f17687l;

    private C0785b(FrameLayout frameLayout, Group group, StepOSButton stepOSButton, TextView textView, TextView textView2, FrameLayout frameLayout2, Group group2, TextView textView3, LoadingView loadingView, View view, MyRecyclerView myRecyclerView, StepOSTitleBar stepOSTitleBar) {
        this.f17676a = frameLayout;
        this.f17677b = group;
        this.f17678c = stepOSButton;
        this.f17679d = textView;
        this.f17680e = textView2;
        this.f17681f = frameLayout2;
        this.f17682g = group2;
        this.f17683h = textView3;
        this.f17684i = loadingView;
        this.f17685j = view;
        this.f17686k = myRecyclerView;
        this.f17687l = stepOSTitleBar;
    }

    public static C0785b a(View view) {
        int i5 = R.id.aicy_group;
        Group group = (Group) C0756a.a(view, R.id.aicy_group);
        if (group != null) {
            i5 = R.id.aicy_request_layer_btn;
            StepOSButton stepOSButton = (StepOSButton) C0756a.a(view, R.id.aicy_request_layer_btn);
            if (stepOSButton != null) {
                i5 = R.id.aicy_request_layer_message;
                TextView textView = (TextView) C0756a.a(view, R.id.aicy_request_layer_message);
                if (textView != null) {
                    i5 = R.id.aicy_request_layer_title;
                    TextView textView2 = (TextView) C0756a.a(view, R.id.aicy_request_layer_title);
                    if (textView2 != null) {
                        i5 = R.id.balloonFrame;
                        FrameLayout frameLayout = (FrameLayout) C0756a.a(view, R.id.balloonFrame);
                        if (frameLayout != null) {
                            i5 = R.id.loading_group;
                            Group group2 = (Group) C0756a.a(view, R.id.loading_group);
                            if (group2 != null) {
                                i5 = R.id.loading_text;
                                TextView textView3 = (TextView) C0756a.a(view, R.id.loading_text);
                                if (textView3 != null) {
                                    i5 = R.id.loading_view;
                                    LoadingView loadingView = (LoadingView) C0756a.a(view, R.id.loading_view);
                                    if (loadingView != null) {
                                        i5 = R.id.mask;
                                        View viewA = C0756a.a(view, R.id.mask);
                                        if (viewA != null) {
                                            i5 = R.id.recycler_view;
                                            MyRecyclerView myRecyclerView = (MyRecyclerView) C0756a.a(view, R.id.recycler_view);
                                            if (myRecyclerView != null) {
                                                i5 = R.id.title_bar;
                                                StepOSTitleBar stepOSTitleBar = (StepOSTitleBar) C0756a.a(view, R.id.title_bar);
                                                if (stepOSTitleBar != null) {
                                                    return new C0785b((FrameLayout) view, group, stepOSButton, textView, textView2, frameLayout, group2, textView3, loadingView, viewA, myRecyclerView, stepOSTitleBar);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C0785b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C0785b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_digital_wellbeing, viewGroup, false);
        if (z5) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public FrameLayout b() {
        return this.f17676a;
    }
}
