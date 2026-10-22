package com.stepos.appcenter.appcentersdk.data;

/* loaded from: classes3.dex */
public class ResultValue<T> {
    private int code;
    private String message;
    private String redirect;
    private T value;

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getRedirect() {
        return this.redirect;
    }

    public T getValue() {
        return this.value;
    }

    public void setCode(int i10) {
        this.code = i10;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setRedirect(String str) {
        this.redirect = str;
    }

    public void setValue(T t10) {
        this.value = t10;
    }

    public String toString() {
        return "ResultValue{code=" + this.code + ", message='" + this.message + "', value=" + this.value + ", redirect='" + this.redirect + "'}";
    }
}
