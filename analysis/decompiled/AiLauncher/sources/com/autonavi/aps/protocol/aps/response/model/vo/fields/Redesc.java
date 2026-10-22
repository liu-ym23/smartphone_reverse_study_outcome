package com.autonavi.aps.protocol.aps.response.model.vo.fields;

/* loaded from: classes.dex */
public enum Redesc {
    OK(0, "成功"),
    FAILUR(61, "定位失败的的类型-无法定位"),
    READ(62, "读取xml数据时出错"),
    XML_NULL(63, "xml为空"),
    XML_WRONG(64, "xml格式不标准，解析出错"),
    SRC_NULL(65, "xml中src为空"),
    SRC_NO_IN_DB(66, "数据库表中没有该src"),
    XML_WRONG_DECODE(67, "解密完获取的xml格式不标准，解析出错"),
    LICENSE_WRONG(68, "xml中的license和数据库表中的不一致或者 数据库中没有该license"),
    DECODE_WRONG(69, "加密的数据有问题，解密时出错"),
    BLACK_LIST(70, "xml中的imei或serverip被拉入黑名单"),
    WHITE_LIST(71, "ip不在白名单里"),
    FORM_WRONG(72, "请求格式不对，比如只能xml请求时用的json请求"),
    KEY_BLACK_LIST(73, "key在黑名单里"),
    USER_BLACK_LIST(74, "imei在黑名单里"),
    LOCATION_NO(75, "不能进行普通定位"),
    IP_LOCATION_NO(76, "不能进行ip定位"),
    WIFI_ONLY(77, "无基站单wifi"),
    NO_VALUE(78, "无效数据"),
    VER_WRONG(79, "版本错误"),
    RESLUT_WRONG(80, "定位结果不可信"),
    PRO_WRONG(81, "定位失败的的类型-程序出错"),
    LICENSE_LIMIT(82, "license被限流"),
    KEY_LIMIT(83, "key被限流"),
    THICKLTR_MOBILEWIFI_WRONG(84, "定位失败的的类型-粗定位thickltr中移动WiFi主动转失败"),
    AMAP_SCENE_LIMIT(85, "高德地图场景限流"),
    ACTIVE_AP(610, "定位失败的的类型-全部为活动AP错误（包括移动AP，公交AP，数据库中权重小于0.8，位置多于4个不包括4的AP）"),
    ACTIVEAP_OTHERLOSE(612, "定位失败的的类型-wifi没有成功的AP，要么是活动AP，要么是数据库中没有值得AP"),
    STY_NO_LOC_FAIL(101, "基站WIFI均无有效位置转失败"),
    STY_HISCTX_CONFLICT_FAIL(102, "上下文冲突转失败"),
    STY_ONLY_ONE_WIFI_FAIL(103, "单WIFI转失败"),
    STY_AMAP_UNFRESH_FAIL(104, "amap不刷新转失败"),
    STY_LOC_FILTER_FAIL(105, "规则过滤（克隆WIFI转失败)"),
    STY_RESOLVE_CONFLICT_FAIL(106, "解冲突转失败");


    /* renamed from: a, reason: collision with root package name */
    private Short f19117a;

    /* renamed from: b, reason: collision with root package name */
    private String f19118b;

    Redesc(Short sh, String str) {
        this.f19117a = sh;
        this.f19118b = str;
    }

    public static Redesc fromShort(short s10) {
        if (s10 == 0) {
            return OK;
        }
        if (s10 == 610) {
            return ACTIVE_AP;
        }
        if (s10 == 612) {
            return ACTIVEAP_OTHERLOSE;
        }
        switch (s10) {
            case 61:
                return FAILUR;
            case 62:
                return READ;
            case 63:
                return XML_NULL;
            case 64:
                return XML_WRONG;
            case 65:
                return SRC_NULL;
            case 66:
                return SRC_NO_IN_DB;
            case 67:
                return XML_WRONG_DECODE;
            case 68:
                return LICENSE_WRONG;
            case 69:
                return DECODE_WRONG;
            case 70:
                return BLACK_LIST;
            case 71:
                return WHITE_LIST;
            case 72:
                return FORM_WRONG;
            case 73:
                return KEY_BLACK_LIST;
            case 74:
                return USER_BLACK_LIST;
            case 75:
                return LOCATION_NO;
            case 76:
                return IP_LOCATION_NO;
            case 77:
                return WIFI_ONLY;
            case 78:
                return NO_VALUE;
            case 79:
                return VER_WRONG;
            case 80:
                return RESLUT_WRONG;
            case 81:
                return PRO_WRONG;
            case 82:
                return LICENSE_LIMIT;
            case 83:
                return KEY_LIMIT;
            case 84:
                return THICKLTR_MOBILEWIFI_WRONG;
            case 85:
                return AMAP_SCENE_LIMIT;
            default:
                switch (s10) {
                    case 101:
                        return STY_NO_LOC_FAIL;
                    case 102:
                        return STY_HISCTX_CONFLICT_FAIL;
                    case 103:
                        return STY_ONLY_ONE_WIFI_FAIL;
                    case 104:
                        return STY_AMAP_UNFRESH_FAIL;
                    case 105:
                        return STY_LOC_FILTER_FAIL;
                    case 106:
                        return STY_RESOLVE_CONFLICT_FAIL;
                    default:
                        return null;
                }
        }
    }

    public static Redesc fromString(String str) {
        try {
            return fromShort(Short.parseShort(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public Short getCode() {
        return this.f19117a;
    }

    public String getDescription() {
        return this.f19118b;
    }
}
