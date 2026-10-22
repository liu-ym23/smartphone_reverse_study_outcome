package com.stepos.alphame.request;

import B0.g;
import com.stepos.alphame.NotProguard;

@NotProguard
/* loaded from: classes.dex */
public class PersonaOLBean {
    private String aqi;
    private String city;
    private int cityid;
    private String highestTemp;
    private String holiday;
    private String lowestTemp;
    private String provinceName;
    private String quality;
    private String temp;
    private int vacation;
    private String weather;
    private String weatherType;

    public String getAqi() {
        return this.aqi;
    }

    public String getCity() {
        return this.city;
    }

    public int getCityid() {
        return this.cityid;
    }

    public String getHighestTemp() {
        return this.highestTemp;
    }

    public String getHoliday() {
        return this.holiday;
    }

    public String getLowestTemp() {
        return this.lowestTemp;
    }

    public String getProvinceName() {
        return this.provinceName;
    }

    public String getQuality() {
        return this.quality;
    }

    public String getTemp() {
        return this.temp;
    }

    public int getVacation() {
        return this.vacation;
    }

    public String getWeather() {
        return this.weather;
    }

    public String getWeatherType() {
        return this.weatherType;
    }

    public void setAqi(String str) {
        this.aqi = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCityid(int i4) {
        this.cityid = i4;
    }

    public void setHighestTemp(String str) {
        this.highestTemp = str;
    }

    public void setHoliday(String str) {
        this.holiday = str;
    }

    public void setLowestTemp(String str) {
        this.lowestTemp = str;
    }

    public void setProvinceName(String str) {
        this.provinceName = str;
    }

    public void setQuality(String str) {
        this.quality = str;
    }

    public void setTemp(String str) {
        this.temp = str;
    }

    public void setVacation(int i4) {
        this.vacation = i4;
    }

    public void setWeather(String str) {
        this.weather = str;
    }

    public void setWeatherType(String str) {
        this.weatherType = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PersonaOLBean{city='");
        sb.append(this.city);
        sb.append("', provinceName='");
        sb.append(this.provinceName);
        sb.append("', cityid=");
        sb.append(this.cityid);
        sb.append(", highestTemp='");
        sb.append(this.highestTemp);
        sb.append("', lowestTemp='");
        sb.append(this.lowestTemp);
        sb.append("', temp='");
        sb.append(this.temp);
        sb.append("', weather='");
        sb.append(this.weather);
        sb.append("', weatherType='");
        sb.append(this.weatherType);
        sb.append("', aqi='");
        sb.append(this.aqi);
        sb.append("', quality='");
        return g.r(sb, this.quality, "'}");
    }
}
