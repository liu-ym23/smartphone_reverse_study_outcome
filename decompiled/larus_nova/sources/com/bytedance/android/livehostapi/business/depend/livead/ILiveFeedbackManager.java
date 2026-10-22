package com.bytedance.android.livehostapi.business.depend.livead;

import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0012JD\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/ILiveFeedbackManager;", "", "addFeedbackView", "", "rootView", "Landroid/view/View;", "optionsParent", "Landroid/view/ViewGroup;", "optionsShouldShowViews", "", "categoryDetail", "Lorg/json/JSONArray;", "filterWords", "callback", "Lcom/bytedance/android/livehostapi/business/depend/livead/ILiveFeedbackManager$Callback;", "enableOptionsStyle", "showFeedbackView", "", "Callback", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveFeedbackManager {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/ILiveFeedbackManager$Callback;", "", "onFeedbackSubmitted", "", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface Callback {
        void onFeedbackSubmitted();
    }

    boolean addFeedbackView(View r100, ViewGroup r101, List<View> r102, JSONArray r103, JSONArray r104, Callback r105);

    boolean enableOptionsStyle();

    void showFeedbackView();
}
