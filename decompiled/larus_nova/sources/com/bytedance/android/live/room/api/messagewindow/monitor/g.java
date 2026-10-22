package com.bytedance.android.live.room.api.messagewindow.monitor;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f99017a = null;

    public static final class a {
    }

    static {
        LinkedHashMap r100 = new LinkedHashMap();
        f99017a = r100;
        r100.put("card_context_init", "卡片管控框架资源初始化");
        r100.put("card_context_release", "卡片管控框架资源释放");
        r100.put("card_manager_intercept_show_card", "卡片展示请求被拦截");
        r100.put("card_manager_request_show_card", "卡片请求展示");
        r100.put("card_manager_intercept_dismiss_card", "卡片销毁请求被拦截");
        r100.put("card_manager_request_dismiss_card", "卡片请求销毁");
        r100.put("card_action_scheduler_execute", "卡片操作任务调度开始执行");
        r100.put("card_action_scheduler_fail_by_null_card", "卡片操作任务调度失败");
        r100.put("show_debounce_ps_intercept", "重复展示卡片操作");
        r100.put("dismiss_debounce_ps_intercept", "重复销毁卡片操作");
        r100.put("suspend_debounce_ps_intercept", "重复挂起卡片操作");
        r100.put("card_show_action_interrupt", "卡片展示流程被中断");
        r100.put("card_dismiss_action_interrupt", "卡片销毁流程被中断");
        r100.put("card_hide_action_interrupt", "卡片隐藏流程被中断");
        r100.put("card_wait_action_interrupt", "卡片挂起流程被中断");
        r100.put("card_processor_handle_fail", "卡片处理流程流转失败");
        r100.put("card_show_action_start", "开始执行卡片展示流程");
        r100.put("card_dismiss_action_start", "开始执行卡片销毁流程");
        r100.put("card_hide_action_start", "开始执行卡片隐藏流程");
        r100.put("card_wait_action_start", "开始执行卡片挂起流程");
        r100.put("intercept_show_ps_count_limit", "卡片展示前被拦截，达到栈溢出阈值");
        r100.put("intercept_show_ps_condition_unsatisfied", "卡片展示前被拦截，业务条件不满足");
        r100.put("intercept_show_ps_error", "卡片展示前被拦截，拦截策略的rx执行error");
        r100.put("intercept_show_ps_intercept", "卡片展示前被业务策略拦截了");
        r100.put("pk_ps_loser_ondefeat_result_unknown", "被击败的卡片没有匹配的策略执行后续逻辑");
        r100.put("pk_ps_give_up_showing", "pk失败，放弃展示");
        r100.put("pk_ps_wait_with_time_out", "pk失败，挂起等待下次展示");
        r100.put("pk_ps_result_unknown", "pk失败，没有匹配的策略执行后续逻辑");
        r100.put("attach_container_ps_fail_by_null_container", "加载卡片内容失败，管控容器未准备");
        r100.put("card_container_load", "卡片管控容器加载卡片内容完毕");
        r100.put("card_container_loaded", "卡片内容已经加载过了，可以直接展示");
        r100.put("hide_card_ps_fail_by_null_container", "隐藏卡片内容失败，管控容器未准备");
        r100.put("transition_anim_ps_fail_by_null_container", "卡片进出场动画执行失败，管控容器未准备");
        r100.put("detach_container_ps_fail_by_null_container", "卸载卡片内容失败，管控容器未准备");
        r100.put("log_card_records_ps_process", "打印卡片列表");
        r100.put("notify_card_show_process", "通知挂起卡片继续展示");
        r100.put("mark_end_ps_action_end", "处理卡片流程结束");
        r100.put("card_ability_lifecycle_show", "卡片内容展示，回调onShow");
        r100.put("card_ability_lifecycle_hide", "卡片内容隐藏，回调onHide");
        r100.put("card_ability_lifecycle_error", "卡片生命周期流转失败");
        r100.put("card_ability_impl_null", "卡片能力提供者为空");
        r100.put("card_context_get_null", "获取卡片上下文失败");
    }
}
