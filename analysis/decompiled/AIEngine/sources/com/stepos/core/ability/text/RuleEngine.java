package com.stepos.core.ability.text;

import gc.i;
import gc.n;
import gc.o;
import gc.q;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.g;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class RuleEngine {
    private static final Regex ADD_MEMBER_REGEX;
    private static final Regex BUILD_REGEX;
    private static final Regex CONCEPT_DIFF_REGEX;
    private static final Regex CONVERT_REGEX;
    private static final Regex DATA_ANALYSIS_REGEX;
    private static final Regex DESIGN_REGEX;
    private static final Regex ERROR_QA_REGEX;
    private static final Regex FILE_ANALYSIS_REGEX;
    private static final Regex GENERATE_REGEX;
    private static final Regex LANG_CODE_REGEX;
    public static final String LLM_FALLBACK = "__LLM_FALLBACK__";
    private static final Regex QUERY_REGEX;
    private static final Regex REWORD_REGEX;
    private static final Regex ROUTE_REGEX;
    private static final Regex SAVE_REGEX;
    private static final Regex SCHEDULE_REGEX;
    private static final Regex SEND_EMAIL_REGEX;
    private static final Regex WRITE_TEXT_REGEX;
    public static final RuleEngine INSTANCE = new RuleEngine();
    private static final List<String> TRAILING = m.b0("！", "？", "。", "~", "～", "呀", "啊", "吧", "了", "啦", "呢", "哈", "嘛");
    private static final List<String> GREETING_PATTERNS = m.b0("你好", "您好", "嗨", "hi", "hello", "hey", "早上好", "下午好", "晚上好", "早安", "晚安", "good morning", "good afternoon", "good evening", "good night");
    private static final List<String> FAREWELL_PATTERNS = m.b0("再见", "拜拜", "bye", "goodbye", "see you", "回见", "告辞");
    private static final List<String> THANKS_PATTERNS = m.b0("谢谢", "谢谢你", "谢谢啦", "谢谢了", "谢谢你的帮助", "感谢", "感谢你", "多谢", "多谢了", "thanks", "thank you", "thx");
    private static final List<String> AFFIRM_PATTERNS = m.b0("好的", "好", "嗯", "嗯嗯", "行", "行的", "知道了", "明白了", "了解了", "懂了", "是的", "对的", "没错", "ok", "okay", "收到", "收到了");
    private static final List<String> TIME_PATTERNS = m.b0("几点了", "几点啦", "现在几点", "现在几点了", "现在什么时间", "什么时间", "今天几号", "今天几月几号", "今天星期几", "今天周几", "明天几号", "明天星期几");
    private static final List<String> WEATHER_PATTERNS = m.b0("天气怎么样", "天气如何", "今天天气", "今天天气怎么样", "今天天气如何", "明天天气", "明天天气怎么样", "明天天气如何", "会下雨吗", "下雨吗", "今天会下雨吗", "明天会下雨吗");
    private static final Regex SIMPLE_MATH_REGEX = new Regex("^\\s*-?\\d[\\d,.+\\-*/= %()（）]*\\d\\s*[=？?]?\\s*$");
    private static final Regex CHINESE_MATH_REGEX = new Regex("^\\s*\\d+\\s*[+\\-×÷加减乘除]\\s*\\d+\\s*(等于几|等于多少|是多少|=\\s*[?？])?\\s*$");
    private static final Regex CHILD_EXPLAIN_REGEX = new Regex("(小学生|五岁|幼儿园).{0,10}(懂|理解|明白|解释)");
    private static final Regex PROOF_REGEX = new Regex("(推导|推演|论证)");
    private static final Regex REVIEW_REGEX = new Regex("综述");
    private static final Regex SYNTHESIS_REGEX = new Regex("(综合|整合|汇总|结合).{0,15}(报告|论文|文章|数据源?|资料|篇)");
    private static final Regex MULTI_SOURCE_REGEX = new Regex("(根据|基于).{0,5}([二三四五六七八九十]|[2-9]|\\d{2,}).{0,5}[个份封篇条].{0,15}(报告|论文|文章|数据源?|资料)");
    private static final Regex READ_MULTI_REGEX = new Regex("(阅读|读).{0,5}([二三四五六七八九十]|[2-9]|\\d{2,}).{0,5}[个份封篇条].{0,15}(报告|论文|文章|资料)");
    private static final Regex TRANSLATE_GUIDE_REGEX = new Regex("翻译.{0,15}(导读|读书笔记|阅读指南)");
    private static final Regex COUNT_REGEX = new Regex("(\\d+|[二两三四五六七八九十百]+)\\s*[个份封篇条套张道]");
    private static final Map<String, Integer> CHINESE_NUM = kotlin.collections.b.g0(new Pair("二", 2), new Pair("两", 2), new Pair("三", 3), new Pair("四", 4), new Pair("五", 5), new Pair("六", 6), new Pair("七", 7), new Pair("八", 8), new Pair("九", 9), new Pair("十", 10), new Pair("二十", 20), new Pair("三十", 30), new Pair("五十", 50), new Pair("百", 100));
    private static final List<String> BATCH_ACTIONS = m.b0("提取", "归档", "分类", "整理", "创建", "生成", "合并", "迁移", "转换", "归类");
    private static final Regex WRITE_CODE_REGEX = new Regex("(写[个一]?|开发[个一]?|实现[个一]?|做[个一]?).{0,12}(脚本|代码|程序|函数|组件|模块|正则|表达式|应用|工具|生成器|插件|爬虫)");

    static {
        RegexOption regexOption = RegexOption.f10095b;
        LANG_CODE_REGEX = new Regex("用\\s*(python|java|javascript|js|kotlin|go|rust|c\\+\\+|swift|react|vue|angular|shell|bash|sql|typescript|ts|php|ruby|dart|flutter)\\s*.{0,8}(写|开发|实现|做|搭建)", 0);
        WRITE_TEXT_REGEX = new Regex("(写|撰写|起草).{0,20}(邮件|信件|文章|报告|文档|简报|科普|通知|交接|策划)");
        SEND_EMAIL_REGEX = new Regex("发.{0,3}(邮件|信件)");
        FILE_ANALYSIS_REGEX = new Regex("(分析|读|看看|检查|解析).{0,15}\\S+\\.(csv|xlsx?|pdf|json|txt|xml|yaml|log)");
        DATA_ANALYSIS_REGEX = new Regex("分析.{0,15}(数据|走势|趋势|分布|销售|报表)");
        DESIGN_REGEX = new Regex("设计.{0,12}(方案|策略|架构|模式)");
        BUILD_REGEX = new Regex("(做[个一]?|搭建[个一]?|开发[个一]?).{0,12}(工具|系统|平台)");
        GENERATE_REGEX = new Regex("生成.{0,10}(测试|假|模拟|mock|样本)");
        CONVERT_REGEX = new Regex("(转成|转换成?|转为).{0,8}(html|pdf|csv|json|markdown|md|word|excel)");
        SCHEDULE_REGEX = new Regex("(安排|预约|预定).{0,5}(会议|日程|行程)");
        SAVE_REGEX = new Regex("^(保存|转发)(一下)?");
        QUERY_REGEX = new Regex("(查一下|找一下|查查|查下|帮我查|查询|帮我找).{0,15}(物流|快递|记录|排班|违章|到哪|进度|状态)");
        ROUTE_REGEX = new Regex("(规划|导航).{0,10}(路线|路径|怎么走|怎么去)");
        ADD_MEMBER_REGEX = new Regex("(加到|添加到|拉到|拉进|加入).{0,10}(组|群|团队|频道)");
        REWORD_REGEX = new Regex("(改成|改写成|换成).{0,10}(语气|风格|口吻|格式)");
        ERROR_QA_REGEX = new Regex("(返回|报了?错?).{0,8}\\d{3}.{0,10}(排查|什么意思|怎么回事|怎么办)");
        CONCEPT_DIFF_REGEX = new Regex("(解释|说明|说说|讲讲).{0,20}(和|与|跟).{0,20}(区别|不同)");
    }

    private RuleEngine() {
    }

    private final int extractCount(String str) {
        Object next;
        i iVarB = COUNT_REGEX.b(str, 0);
        if (iVarB != null) {
            String str2 = (String) ((i.a) iVarB.a()).get(1);
            Integer numC0 = n.c0(str2);
            if (numC0 != null) {
                return numC0.intValue();
            }
            Iterator<T> it = CHINESE_NUM.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (o.k0(str2, (String) ((Map.Entry) next).getKey(), false)) {
                    break;
                }
            }
            Map.Entry entry = (Map.Entry) next;
            Integer num = entry != null ? (Integer) entry.getValue() : null;
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    private final boolean matchesAny(String str, List<String> list) {
        if (list != null && list.isEmpty()) {
            return false;
        }
        for (String str2 : list) {
            if (!g.b(str, str2)) {
                List<String> list2 = TRAILING;
                if (list2 == null || !list2.isEmpty()) {
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        if (g.b(str, str2 + ((String) it.next()))) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final String classify(String text) {
        List<String> list;
        g.f(text, "text");
        String lowerCase = text.toLowerCase(Locale.ROOT);
        g.e(lowerCase, "toLowerCase(...)");
        String string = q.L0(lowerCase).toString();
        if (matchesAny(string, GREETING_PATTERNS) || matchesAny(string, FAREWELL_PATTERNS) || matchesAny(string, THANKS_PATTERNS) || matchesAny(string, AFFIRM_PATTERNS) || matchesAny(string, TIME_PATTERNS) || matchesAny(string, WEATHER_PATTERNS) || SIMPLE_MATH_REGEX.c(string) || CHINESE_MATH_REGEX.c(string)) {
            return "SIMPLE";
        }
        if (q.l0(text, "ELI5", false)) {
            return "REASONING";
        }
        if ((q.l0(string, "大白话", false) && new Regex("pdf|文档|长文").a(string)) || CHILD_EXPLAIN_REGEX.a(string) || PROOF_REGEX.a(string)) {
            return "REASONING";
        }
        if (REVIEW_REGEX.a(string) || SYNTHESIS_REGEX.a(string) || MULTI_SOURCE_REGEX.a(string) || READ_MULTI_REGEX.a(string) || TRANSLATE_GUIDE_REGEX.a(string)) {
            return "RESEARCH";
        }
        if (extractCount(string) >= 3 && ((list = BATCH_ACTIONS) == null || !list.isEmpty())) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (q.l0(string, (String) it.next(), false)) {
                    return "COMPLEX";
                }
            }
        }
        return (WRITE_CODE_REGEX.a(string) || LANG_CODE_REGEX.a(text) || WRITE_TEXT_REGEX.a(string) || SEND_EMAIL_REGEX.a(string) || FILE_ANALYSIS_REGEX.a(string) || DATA_ANALYSIS_REGEX.a(string) || DESIGN_REGEX.a(string) || BUILD_REGEX.a(string) || GENERATE_REGEX.a(string) || CONVERT_REGEX.a(string) || SCHEDULE_REGEX.a(string)) ? "MEDIUM" : (SAVE_REGEX.a(string) || QUERY_REGEX.a(string) || ROUTE_REGEX.a(string) || ADD_MEMBER_REGEX.a(string) || REWORD_REGEX.a(string) || ERROR_QA_REGEX.a(string) || CONCEPT_DIFF_REGEX.a(string)) ? "SIMPLE" : LLM_FALLBACK;
    }
}
