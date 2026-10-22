package com.stepos.familyguard.net.entity;

import java.util.List;

/* loaded from: classes.dex */
public class ConfigEntity {
    public Long lastModify;
    public List<ConfigPhoneEntity> phone;
    public List<ConfigSmsEntity> sms;
    public List<ConfigSmsPhoneEntity> smsPhone;
    public Boolean updated;
}
