package com.bytedance.android.shopping.buynow.data.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes13.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/buynow/data/model/CheckPointType;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface CheckPointType {
    public static final String CHECK_ORDER_START = "check_order_start";
    public static final a Companion = null;
    public static final String EDIT_REQUEST_FAILED = "edit_request_failed";
    public static final String EDIT_REQUEST_START = "edit_request_start";
    public static final String EDIT_REQUEST_SUCCESS = "edit_request_success";
    public static final String ENTER_PAGE = "enter_page";
    public static final String ERROR_PAGE_SHOW = "error_page_show";
    public static final String GOTO_PAGE = "goto_page";
    public static final String ORDER_REQUEST_FAILED = "order_request_failed";
    public static final String ORDER_REQUEST_START = "order_request_start";
    public static final String ORDER_REQUEST_SUCCESS = "order_request_success";
    public static final String PAY_START = "pay_start";
    public static final String RENDER_REQUEST_FAILED = "render_request_failed";
    public static final String RENDER_REQUEST_START = "render_request_start";
    public static final String RENDER_REQUEST_SUCCESS = "render_request_success";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f170885a = null;

        public a() {
        }

        static {
            f170885a = new a();
        }
    }

    static {
        Companion = a.f170885a;
    }
}
