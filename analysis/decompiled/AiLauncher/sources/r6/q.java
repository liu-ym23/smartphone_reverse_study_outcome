package r6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.detail.TaskWebView;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class q {
    public final TextView resultFallback;
    public final ScrollView resultFallbackScroll;
    public final LinearLayout resultFolderList;
    public final ScrollView resultFolderScroll;
    public final ImageView resultImage;
    public final FrameLayout resultInvalid;
    public final ImageView resultInvalidIcon;
    public final TextView resultInvalidReason;
    public final TextView resultInvalidRetry;
    public final FrameLayout resultRenderMask;
    public final LinearLayout resultRenderMaskLoading;
    public final ProgressBar resultRenderMaskProgress;
    public final ImageView resultRenderMaskSnapshot;
    public final FrameLayout resultViewport;
    public final TaskWebView resultWeb;
    private final FrameLayout rootView;

    public q(FrameLayout frameLayout, TextView textView, ScrollView scrollView, LinearLayout linearLayout, ScrollView scrollView2, ImageView imageView, FrameLayout frameLayout2, ImageView imageView2, TextView textView2, TextView textView3, FrameLayout frameLayout3, LinearLayout linearLayout2, ProgressBar progressBar, ImageView imageView3, FrameLayout frameLayout4, TaskWebView taskWebView) {
        this.rootView = frameLayout;
        this.resultFallback = textView;
        this.resultFallbackScroll = scrollView;
        this.resultFolderList = linearLayout;
        this.resultFolderScroll = scrollView2;
        this.resultImage = imageView;
        this.resultInvalid = frameLayout2;
        this.resultInvalidIcon = imageView2;
        this.resultInvalidReason = textView2;
        this.resultInvalidRetry = textView3;
        this.resultRenderMask = frameLayout3;
        this.resultRenderMaskLoading = linearLayout2;
        this.resultRenderMaskProgress = progressBar;
        this.resultRenderMaskSnapshot = imageView3;
        this.resultViewport = frameLayout4;
        this.resultWeb = taskWebView;
    }

    public static q a(View view) {
        int i10 = R$id.result_fallback;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.result_fallback_scroll;
            ScrollView scrollView = (ScrollView) C5437a.a(view, i10);
            if (scrollView != null) {
                i10 = R$id.result_folder_list;
                LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout != null) {
                    i10 = R$id.result_folder_scroll;
                    ScrollView scrollView2 = (ScrollView) C5437a.a(view, i10);
                    if (scrollView2 != null) {
                        i10 = R$id.result_image;
                        ImageView imageView = (ImageView) C5437a.a(view, i10);
                        if (imageView != null) {
                            i10 = R$id.result_invalid;
                            FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
                            if (frameLayout != null) {
                                i10 = R$id.result_invalid_icon;
                                ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                                if (imageView2 != null) {
                                    i10 = R$id.result_invalid_reason;
                                    TextView textView2 = (TextView) C5437a.a(view, i10);
                                    if (textView2 != null) {
                                        i10 = R$id.result_invalid_retry;
                                        TextView textView3 = (TextView) C5437a.a(view, i10);
                                        if (textView3 != null) {
                                            i10 = R$id.result_render_mask;
                                            FrameLayout frameLayout2 = (FrameLayout) C5437a.a(view, i10);
                                            if (frameLayout2 != null) {
                                                i10 = R$id.result_render_mask_loading;
                                                LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                                                if (linearLayout2 != null) {
                                                    i10 = R$id.result_render_mask_progress;
                                                    ProgressBar progressBar = (ProgressBar) C5437a.a(view, i10);
                                                    if (progressBar != null) {
                                                        i10 = R$id.result_render_mask_snapshot;
                                                        ImageView imageView3 = (ImageView) C5437a.a(view, i10);
                                                        if (imageView3 != null) {
                                                            i10 = R$id.result_viewport;
                                                            FrameLayout frameLayout3 = (FrameLayout) C5437a.a(view, i10);
                                                            if (frameLayout3 != null) {
                                                                i10 = R$id.result_web;
                                                                TaskWebView taskWebView = (TaskWebView) C5437a.a(view, i10);
                                                                if (taskWebView != null) {
                                                                    return new q((FrameLayout) view, textView, scrollView, linearLayout, scrollView2, imageView, frameLayout, imageView2, textView2, textView3, frameLayout2, linearLayout2, progressBar, imageView3, frameLayout3, taskWebView);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static q b(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.stub_task_detail_result, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
