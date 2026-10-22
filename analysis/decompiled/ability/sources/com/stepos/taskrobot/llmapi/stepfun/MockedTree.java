package com.stepos.taskrobot.llmapi.stepfun;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/MockedTree;", "", AppAgent.CONSTRUCT, "()V", "pathNodes", "", "getPathNodes", "()Ljava/lang/String;", "slotMaps", "getSlotMaps", "task", "getTask", "task2", "getTask2", "slot", "getSlot", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MockedTree {
    public static final MockedTree INSTANCE = new MockedTree();
    private static final String pathNodes = "[\n    {\n      \"op_type\": \"comprehensive_action\",\n      \"op_params\": {\n        \"app_name\": \"美团\"\n      },\n      \"op_desc\": \"打开'美团'APP\",\n      \"op_desc_display\": \"打开'美团'APP\",\n      \"node_type\": \"operation\",\n      \"subtask_history_name\": \"\"\n    },\n    {\n      \"op_type\": \"comprehensive_action\",\n      \"op_params\": {\n        \"task_entry\": \"外卖\"\n      },\n      \"op_desc\": \"进入外卖页面\",\n      \"op_desc_display\": \"进入外卖页面\",\n      \"node_type\": \"operation\",\n      \"subtask_history_name\": \"任务入口\"\n    },\n    {\n      \"op_type\": \"comprehensive_action\",\n      \"op_params\": {\n        \"target_shops\": [\n          \"肯德基\"\n        ]\n      },\n      \"op_desc\": \"搜索店铺：'肯德基'\",\n      \"op_desc_display\": \"搜索店铺：'肯德基'\",\n      \"node_type\": \"operation\",\n      \"subtask_history_name\": \"搜索商品或店铺\"\n    },\n    {\n      \"op_type\": \"comprehensive_action\",\n      \"op_params\": {},\n      \"op_desc\": \"选择店铺\",\n      \"op_desc_display\": \"选择店铺\",\n      \"node_type\": \"operation\",\n      \"subtask_history_name\": \"\"\n    },\n    {\n      \"op_type\": \"comprehensive_action\",\n      \"op_params\": {\n        \"product_specifications\": [\n          \"劲脆鸡腿堡 x1\"\n        ]\n      },\n      \"op_desc\": \"搜索并选择商品：劲脆鸡腿堡 x1\",\n      \"op_desc_display\": \"搜索并选择商品：劲脆鸡腿堡 x1\",\n      \"node_type\": \"operation\",\n      \"subtask_history_name\": \"选择规格和必选品后\"\n    },\n    {\n      \"op_type\": \"comprehensive_action\",\n      \"op_params\": {\n        \"product_specifications\": [\n          \"可乐 x1\"\n        ]\n      },\n      \"op_desc\": \"搜索并选择商品：可乐 x1\",\n      \"op_desc_display\": \"搜索并选择商品：可乐 x1\",\n      \"node_type\": \"operation\",\n      \"subtask_history_name\": \"选择规格和必选品后\"\n    },\n    {\n      \"op_type\": \"comprehensive_action\",\n      \"op_desc\": \"去结算\",\n      \"op_desc_display\": \"去结算\",\n      \"node_type\": \"operation\",\n      \"subtask_history_name\": \"\"\n    },\n    {\n      \"op_type\": \"comprehensive_action\",\n      \"op_params\": {},\n      \"op_desc\": \"选择红包\",\n      \"op_desc_display\": \"选择红包\",\n      \"node_type\": \"operation\",\n      \"subtask_history_name\": \"\"\n    },\n    {\n      \"op_type\": \"comprehensive_action\",\n      \"op_params\": {\n        \"tableware_selection\": \"无需餐具\"\n      },\n      \"op_desc\": \"选择餐具：无需餐具\",\n      \"op_desc_display\": \"选择餐具：无需餐具\",\n      \"node_type\": \"operation\",\n      \"subtask_history_name\": \"餐具选择\"\n    },\n    {\n      \"op_type\": \"comprehensive_action\",\n      \"op_params\": {\n        \"payment_method\": \"极速支付\"\n      },\n      \"op_desc\": \"设置支付方式为'极速支付'\",\n      \"op_desc_display\": \"设置支付方式为'极速支付'\",\n      \"node_type\": \"operation\",\n      \"subtask_history_name\": \"支付方式\"\n    },\n    {\n      \"op_desc_path\": [\n        \"打开'美团'APP\",\n        \"进入外卖页面\",\n        \"搜索店铺：'肯德基'\",\n        \"选择店铺\",\n        \"选择规格：劲脆鸡腿堡 x1\",\n        \"选择规格：可乐 x1\",\n        \"选择红包\",\n        \"选择餐具：无需餐具\",\n        \"设置支付方式为'极速支付'\"\n      ],\n      \"slot_match\": {\n        \"app_name\": \"美团\",\n        \"task_entry\": \"外卖\",\n        \"address\": \"北京市朝阳区三里屯\",\n        \"contact_name\": \"张三\",\n        \"phone_number\": \"13800138000\",\n        \"target_shops\": [\n          \"肯德基\"\n        ],\n        \"product_specifications\": [\n          \"劲脆鸡腿堡 x1\",\n          \"可乐 x1\"\n        ],\n        \"delivery_method\": \"外卖配送\",\n        \"pickup_or_delivery_time\": \"立即配送\",\n        \"tableware_selection\": \"无需餐具\",\n        \"payment_method\": \"极速支付\"\n      },\n      \"node_type\": \"terminal\",\n      \"repetition\": false\n    }\n]";
    private static final String slotMaps = "{\n  \"app_name\": \"美团\",\n  \"task_entry\": \"外卖\",\n  \"address\": \"北京市朝阳区三里屯\",\n  \"contact_name\": \"张三\",\n  \"phone_number\": \"13800138000\",\n  \"target_shops\": [\n    \"肯德基\"\n  ],\n  \"product_specifications\": [\n    \"劲脆鸡腿堡 x1\",\n    \"可乐 x1\"\n  ],\n  \"delivery_method\": \"外卖配送\",\n  \"pickup_or_delivery_time\": \"立即配送\",\n  \"tableware_selection\": \"无需餐具\",\n  \"payment_method\": \"极速支付\"\n}";
    private static final String task = "搜索离当前位置最近的袁记云饺门店并下单一份白菜鲜肉饺|@|1. 打开美团 App，停留在首页。\n2. 点击首页“外卖”入口进入美团外卖。\n3. 查看顶部收货地址是否为当前位置；若不是，点击地址栏，选择“定位到我”并允许定位权限，或手动输入当前地址后保存。\n4. 点击外卖页面顶部搜索框，输入“袁记云饺”，点击“搜索”。\n5. 在搜索结果页，点击“综合排序/筛选”，选择“距离最近”。\n6. 在结果列表中，选择距离显示最短且支持配送到当前地址的“袁记云饺”门店，点击进入店铺。\n7. 在店铺页找到并点击“白菜鲜肉饺”（若店内有搜索框则输入“白菜鲜肉”后选择该商品；若无搜索框，在“饺子/水饺”等分类中向下滑动找到该商品）。\n8. 在商品弹窗中选择规格/份量（如有），数量保持1份，点击“加入购物车”或“立即购买”。\n9. 若加入购物车，点击页面底部“去结算”；若选择“立即购买”则进入结算页。\n10. 在结算页确认收货地址、联系人电话，送达时间选择“尽快送达”，核对商品为“白菜鲜肉饺”且数量1份，设置餐具与备注（可选），勾选可用优惠券。\n11. 选择支付方式（微信支付/支付宝/美团支付等），点击“提交订单”或“去支付”。\n12. 在支付页面点击“确认支付”，完成下单。";
    private static final String task2 = "搜索美团篮球卖家|@|1. 打开美团 App，停留在首页。\n2. 点击搜索框，搜索篮球\n3. 搜索结果呈现，任务结束";
    private static final String slot = "slot {\n  \"task_entry\" : \"外卖\",\n  \"target_shops\" : [ \"袁记云饺\" ],\n  \"sort_type\" : \"距离优先\",\n  \"product_specifications\" : [ \"白菜鲜肉饺，1\" ],\n  \"delivery_method\" : \"外卖配送\",\n  \"app_name\" : \"美团\"\n}";

    private MockedTree() {
    }

    public final String getPathNodes() {
        return pathNodes;
    }

    public final String getSlot() {
        return slot;
    }

    public final String getSlotMaps() {
        return slotMaps;
    }

    public final String getTask() {
        return task;
    }

    public final String getTask2() {
        return task2;
    }
}
