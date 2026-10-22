package com.bytedanceos.common.networkv2.entity.req;

/* JADX INFO: loaded from: classes2.dex */
public class ReqSdaEntity {
    private String did;
    private String download_url;
    private String name;
    private String net_work_status;
    private String packagename;
    private String product_name;
    private SdaPushInfo push_info;
    private String reason;
    private int retry_num;
    private ReqSearchInfo search_info;
    private String search_keywords;
    private String search_type;
    private String source;
    private SdaSourceInfo source_info;
    private String type;
    private String version_code;

    public ReqSdaEntity() {
        this.packagename = "";
        this.name = "";
        this.version_code = "";
        this.download_url = "";
        this.source = "";
        this.type = "";
        this.product_name = "";
        this.reason = "";
        this.search_keywords = "";
        this.search_type = "";
        this.net_work_status = "";
        this.did = "";
        this.retry_num = 0;
    }

    public String getDid() {
        return this.did;
    }

    public String getDownload_url() {
        return this.download_url;
    }

    public String getName() {
        return this.name;
    }

    public String getNet_work_status() {
        return this.net_work_status;
    }

    public String getPackageName() {
        return this.packagename;
    }

    public String getProduct_name() {
        return this.product_name;
    }

    public SdaPushInfo getPush_info() {
        return this.push_info;
    }

    public String getReason() {
        return this.reason;
    }

    public int getRetryNum() {
        return this.retry_num;
    }

    public ReqSearchInfo getSearch_info() {
        return this.search_info;
    }

    public String getSearch_keywords() {
        return this.search_keywords;
    }

    public String getSearch_type() {
        return this.search_type;
    }

    public String getSource() {
        return this.source;
    }

    public SdaSourceInfo getSource_info() {
        return this.source_info;
    }

    public String getType() {
        return this.type;
    }

    public String getVersion_code() {
        return this.version_code;
    }

    public void setDid(String r10) {
        this.did = r10;
    }

    public void setDownload_url(String r10) {
        this.download_url = r10;
    }

    public void setName(String r10) {
        this.name = r10;
    }

    public void setNet_work_status(String r10) {
        this.net_work_status = r10;
    }

    public void setPackageName(String r10) {
        this.packagename = r10;
    }

    public void setProduct_name(String r10) {
        this.product_name = r10;
    }

    public void setPush_info(SdaPushInfo r10) {
        this.push_info = r10;
    }

    public void setReason(String r10) {
        this.reason = r10;
    }

    public void setRetryNum(int r10) {
        this.retry_num = r10;
    }

    public void setSearch_info(ReqSearchInfo r10) {
        this.search_info = r10;
    }

    public void setSearch_keywords(String r10) {
        this.search_keywords = r10;
    }

    public void setSearch_type(String r10) {
        this.search_type = r10;
    }

    public void setSource(String r10) {
        this.source = r10;
    }

    public void setSource_info(SdaSourceInfo r10) {
        this.source_info = r10;
    }

    public void setType(String r10) {
        this.type = r10;
    }

    public void setVersion_code(String r10) {
        this.version_code = r10;
    }
}
