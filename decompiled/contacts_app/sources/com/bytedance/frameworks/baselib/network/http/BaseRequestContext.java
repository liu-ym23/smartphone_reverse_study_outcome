package com.bytedance.frameworks.baselib.network.http;

import java.util.List;
import okhttp3.OkHttpClient;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class BaseRequestContext {
    public AuthCredentials authCredentials;
    public boolean byPassProxy;
    public boolean bypassCookie;
    public boolean bypass_network_status_check;
    public boolean enable_http_cache;
    public JSONObject extraInfo;
    public boolean followRedirectInternal;
    public boolean force_handle_response;
    public boolean force_use_okhttp;
    public boolean ignoreCheckMinInputStreamBufferSize;
    public int input_stream_buffer_size;
    public boolean isCustomizedCookie;
    public boolean is_need_monitor_in_cancel;
    public IOkHttpRequestClientBuilderHook okHttpRequestClientBuilderHook;
    public int output_stream_buffer_size;
    public long protect_timeout;
    public boolean read_error_response;
    public String remoteIp;
    public int request_flag;
    public int request_type_flags;
    public List<RotationHostRetryInfo> rotationHostRetryInfoList;
    public long socket_connect_timeout;
    public long socket_read_timeout;
    public long socket_write_timeout;
    public int status;
    public boolean streaming_force_return_response;
    public long throttle_net_speed;
    public long timeout_connect;
    public long timeout_read;
    public long timeout_write;

    public static class AuthCredentials {
        public String password;
        public String username;

        public AuthCredentials() {
        }

        public String toString() {
            return "AuthCredentials{username=" + this.username + ", password=" + this.password + '}';
        }
    }

    public interface IOkHttpRequestClientBuilderHook {
        void addBuilderConfig(OkHttpClient.Builder r1);
    }

    public static class RotationHostRetryInfo {
        public String host;
        public String path;

        public RotationHostRetryInfo(String r1, String r2) {
            this.host = r1;
            this.path = r2;
        }
    }

    public BaseRequestContext() {
        this.force_use_okhttp = false;
        this.request_type_flags = 0;
        this.bypass_network_status_check = true;
        this.followRedirectInternal = true;
        this.enable_http_cache = false;
        this.is_need_monitor_in_cancel = true;
        this.bypassCookie = false;
        this.isCustomizedCookie = false;
        this.byPassProxy = false;
        this.extraInfo = new JSONObject();
    }
}
